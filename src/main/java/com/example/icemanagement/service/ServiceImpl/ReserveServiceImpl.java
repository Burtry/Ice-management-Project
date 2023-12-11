package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.RecordMapper;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.service.ReserveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Page<ReserveRecords> page = recordsMapper.page(equipmentRecordsPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
