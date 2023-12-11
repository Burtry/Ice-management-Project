package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.ProtectMapper;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.dto.MaintenanceRecordDTO;
import com.example.icemanagement.pojo.entity.MaintenanceRecord;
import com.example.icemanagement.service.ProtectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProtectServiceImpl implements ProtectService {

    @Autowired
    private ProtectMapper protectMapper;

    /**
     * 新增维护计划
     * @param maintenanceRecordDTO
     */
    @Override
    public void insert(MaintenanceRecordDTO maintenanceRecordDTO) {
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        BeanUtils.copyProperties(maintenanceRecordDTO,maintenanceRecord);
        maintenanceRecord.setCreateTime(LocalDateTime.now());
        maintenanceRecord.setUpdateTime(LocalDateTime.now());
        protectMapper.insert(maintenanceRecord);
    }

    /**
     * 分页查看维护计划
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO) {
        PageHelper.startPage(equipmentRecordsPageQueryDTO.getPage(),equipmentRecordsPageQueryDTO.getPageSize());
        Page<MaintenanceRecord> page = protectMapper.page(equipmentRecordsPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }


    /**
     * 修改维护计划
     * @param maintenanceRecordDTO
     */
    @Override
    public void update(MaintenanceRecordDTO maintenanceRecordDTO) {
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        BeanUtils.copyProperties(maintenanceRecordDTO,maintenanceRecord);
        maintenanceRecord.setUpdateTime(LocalDateTime.now());
        protectMapper.update(maintenanceRecord);

    }

    /**
     * 批量删除维护计划
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        protectMapper.delete(ids);
    }
}
