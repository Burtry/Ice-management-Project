package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.BaseException;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.RecordMapper;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.service.ReserveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private RecordMapper recordsMapper;



    /**
     * 分页查看器材租借记录
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO) {
        PageHelper.startPage(equipmentRecordsPageQueryDTO.getPage(),equipmentRecordsPageQueryDTO.getPageSize());
        Page<ReserveRecords> page = recordsMapper.page();
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 修改租借状态
     * @param status
     */

    @Override
    public void updateByStatus(Integer status,Long id) {
        ReserveRecords reserveRecord = new ReserveRecords();
        reserveRecord.setId(id);
        reserveRecord.setStatus(status);
        reserveRecord.setUpdateTime(LocalDateTime.now());
        recordsMapper.update(reserveRecord);
    }

    /**
     * 根据id查询租借记录
     * @param id
     * @return
     */
    @Override
    public ReserveRecords getById(Long id) {
        ReserveRecords reserveRecord = recordsMapper.getById(id);
        if (reserveRecord == null) {
            throw new BaseException("租借记录不存在");
        }
        return reserveRecord;
    }
}
