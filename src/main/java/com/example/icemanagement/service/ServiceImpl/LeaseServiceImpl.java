package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.BaseException;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.RecordsMapper;
import com.example.icemanagement.pojo.dto.HistoryPageQueryDTO;
import com.example.icemanagement.pojo.dto.LeaseRecordsDTO;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.example.icemanagement.pojo.vo.LeaseRecordsVO;
import com.example.icemanagement.pojo.vo.ReserveRecordsVO;
import com.example.icemanagement.service.EquipmentService;
import com.example.icemanagement.service.LeaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private RecordsMapper recordsMapper;

    @Autowired
    private EquipmentService equipmentService;


    /**
     * 分页查看器材租借记录
     * @param recordsPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(RecordsPageQueryDTO recordsPageQueryDTO) {
        PageHelper.startPage(recordsPageQueryDTO.getPage(), recordsPageQueryDTO.getPageSize());
        Page<LeaseRecords> page = recordsMapper.leasePage();
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 修改租借状态
     * @param status
     */

    @Override
    public void updateByStatus(Integer status,Long id) {
        LeaseRecords reserveRecord = new LeaseRecords();
        reserveRecord.setId(id);
        reserveRecord.setUpdateTime(LocalDateTime.now());
        reserveRecord.setStatus(status);
        recordsMapper.leaseUpdate(reserveRecord);
    }

    /**
     * 根据id查询租借记录
     * @param id
     * @return
     */
    @Override
    public LeaseRecords getById(Long id) {
        LeaseRecords reserveRecord = recordsMapper.leaseGetById(id);
        if (reserveRecord == null) {
            throw new BaseException("租借记录不存在");
        }
        return reserveRecord;
    }

    /**
     * 根据用户id查看该用户的租借信息
     * @param userId
     * @return
     */
    @Override
    public List<LeaseRecordsVO> getByUserId(Long userId) {
        return recordsMapper.listLeaseRecords(userId);
    }

    /**
     * 分页查看用户租借的历史记录
     * @param historyPageQueryDTO
     * @return
     */
    @Override
    public PageResult historyPage(HistoryPageQueryDTO historyPageQueryDTO) {
        PageHelper.startPage(historyPageQueryDTO.getPage(), historyPageQueryDTO.getPageSize());
        List<LeaseRecordsVO> leaseRecordsVOs = recordsMapper.listLeaseRecords(historyPageQueryDTO.getUserId());
        Integer total = recordsMapper.leaseGetTotalByUserId(historyPageQueryDTO.getUserId());
        return new PageResult(total,leaseRecordsVOs);
    }

    /**
     * 创建租借信息
     * @param leaseRecordsDTO
     */
    @Override
    public void createLease(LeaseRecordsDTO leaseRecordsDTO) {



        //获取该器材信息
        Long equipmentId = leaseRecordsDTO.getEquipmentId();
        Equipment equipment = equipmentService.getById(equipmentId);

        //判断是否存在
        if (equipment == null) {
            throw new BaseException("该器材不存在!");
        }

        //判断器材数量是否大于一，如果大于1，则闯将租借记录，否则抛出器材不足的异常
        if (equipment.getNumber() <= 0) {
            throw new BaseException("器材不足!");
        }

        LeaseRecords leaseRecords = new LeaseRecords();
        BeanUtils.copyProperties(leaseRecordsDTO,leaseRecords);
        leaseRecords.setCreateTime(LocalDateTime.now());
        leaseRecords.setUpdateTime(LocalDateTime.now());

        //将此器材的状态设置为1，已借出
        leaseRecords.setStatus(1);
        recordsMapper.createLease(leaseRecords);

        //获取insert语句生成的主键值
        Long id = leaseRecords.getId();
        log.info("insert语句生成的主键值id:{}",id);
    }


    /**
     * 用户取消租借
     * @param id
     */
    @Override
    public void cancel(Long id) {
        LeaseRecords leaseRecords = recordsMapper.leaseGetById(id);
        if (leaseRecords == null) {
            throw new BaseException("该租借记录不存在!");
        }
        //设置成未租借
        leaseRecords.setStatus(0);
        leaseRecords.setUpdateTime(LocalDateTime.now());
        leaseRecords.setRemark("用户取消租借!");
        recordsMapper.leaseUpdate(leaseRecords);
    }
}
