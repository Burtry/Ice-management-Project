package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.BaseException;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.mapper.RecordsMapper;
import com.example.icemanagement.pojo.dto.HistoryPageQueryDTO;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.dto.ReserveRecordsDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.pojo.vo.ReserveRecordsVO;
import com.example.icemanagement.service.ReserveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private RecordsMapper recordsMapper;


    /**
     * 分页查询预约记录
     * @param recordsPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(RecordsPageQueryDTO recordsPageQueryDTO) {
        PageHelper.startPage(recordsPageQueryDTO.getPage(), recordsPageQueryDTO.getPageSize());
        Page<ReserveRecords> page = recordsMapper.reservePage();
        return new PageResult(page.getTotal(),page.getResult());

    }

    /**
     * 根据id查询预约记录
     * @param id
     * @return
     */
    @Override
    public ReserveRecords getById(Long id) {
        ReserveRecords reserveRecords = recordsMapper.reserveGetById(id);
        if (reserveRecords == null) {
            throw new BaseException("该预约记录不存在");
        }
        return reserveRecords;
    }

    /**
     * 根据id修改场地状态
     * @param status
     * @param id
     */
    @Override
    public void updateByStatus(Integer status, Long id) {
        ReserveRecords reserveRecords = new ReserveRecords();
        reserveRecords.setUpdateTime(LocalDateTime.now());
        reserveRecords.setId(id);
        reserveRecords.setStatus(status);
        recordsMapper.reserveUpdate(reserveRecords);
    }

    /**
     * 用户端创建预约
     * @param reserveRecordsDTO
     */
    @Override
    public void createReserve(ReserveRecordsDTO reserveRecordsDTO) {
        ReserveRecords reserveRecords = new ReserveRecords();
        BeanUtils.copyProperties(reserveRecordsDTO,reserveRecords);
        reserveRecords.setCreateTime(LocalDateTime.now());
        reserveRecords.setUpdateTime(LocalDateTime.now());

        //场地已预约，状态设置为1
        reserveRecords.setStatus(1);

        recordsMapper.createReserve(reserveRecords);

        //获取insert语句生成的主键值
        Long id = reserveRecords.getId();
        log.info("insert语句生成的主键值id:{}",id);

    }
    /**
     * 根据用户id查看用户预约
     * @param
     * @return
     */
    @Override
    public List<ReserveRecordsVO> list(Long id) {
       return recordsMapper.listReserveRecords(id);
    }

    /**
     * 取消预约
     * @param id
     */
    @Override
    public void cancel(Long id) {
        ReserveRecords reserveRecord = recordsMapper.reserveGetById(id);
        if (reserveRecord == null) {
            throw new BaseException("预约信息不存在!");
        }
        //设置场地状态为0(未预约)
        reserveRecord.setStatus(0);
        //更新时间
        reserveRecord.setUpdateTime(LocalDateTime.now());

        reserveRecord.setRemark("用户取消预约");
        recordsMapper.reserveUpdate(reserveRecord);
    }

    /**
     * 管理编辑预约
     */
    @Override
    public void update(ReserveRecordsDTO reserveRecordsDTO) {

        ReserveRecords reserveRecord = recordsMapper.reserveGetById(reserveRecordsDTO.getId());
        BeanUtils.copyProperties(reserveRecordsDTO,reserveRecord);
        reserveRecord.setUpdateTime(LocalDateTime.now());
        recordsMapper.reserveUpdate(reserveRecord);

    }

    /**
     * 查看本用户的预约历史记录
     * @param historyPageQueryDTO
     * @return
     */
    @Override
    public PageResult historyPage(HistoryPageQueryDTO historyPageQueryDTO) {
        PageHelper.startPage(historyPageQueryDTO.getPage(), historyPageQueryDTO.getPageSize());
        List<ReserveRecordsVO> reserveRecordsVOs = recordsMapper.listReserveRecords(historyPageQueryDTO.getUserId());
        Integer total = recordsMapper.reserveGetTotalByUserId(historyPageQueryDTO.getUserId());
        return new PageResult(total,reserveRecordsVOs);
    }
}
