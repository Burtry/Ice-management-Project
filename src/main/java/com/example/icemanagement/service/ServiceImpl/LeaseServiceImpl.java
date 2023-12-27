package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.BaseException;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.RecordsMapper;
import com.example.icemanagement.pojo.dto.HistoryPageQueryDTO;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.example.icemanagement.pojo.vo.LeaseRecordsVO;
import com.example.icemanagement.pojo.vo.ReserveRecordsVO;
import com.example.icemanagement.service.LeaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private RecordsMapper recordsMapper;

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
}
