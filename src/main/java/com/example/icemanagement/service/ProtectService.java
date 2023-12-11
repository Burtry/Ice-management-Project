package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.dto.MaintenanceRecordDTO;

public interface ProtectService {
    /**
     * 新增维护计划
     * @param maintenanceRecordDTO
     */
    void insert(MaintenanceRecordDTO maintenanceRecordDTO);

    /**
     * 分页查看维护计划
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    PageResult page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO);
}
