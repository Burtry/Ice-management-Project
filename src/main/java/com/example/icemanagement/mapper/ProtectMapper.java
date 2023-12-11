package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.MaintenanceRecord;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProtectMapper {
    /**
     * 新增维护计划
     * @param maintenanceRecord
     */
    void insert(MaintenanceRecord maintenanceRecord);

    /**
     * 分页查看维护计划
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    @Select("select * from icemanagement.equipment_maintenance_records order by create_time desc")
    Page<MaintenanceRecord> page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO);
}
