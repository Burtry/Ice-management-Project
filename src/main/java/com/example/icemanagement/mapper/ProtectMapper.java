package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.MaintenanceRecord;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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


    /**
     * 更新维护计划
     * @param maintenanceRecord
     */
    void update(MaintenanceRecord maintenanceRecord);

    /**
     * 根据ids批量删除维护计划
     * @param ids
     */
    void delete(List<Long> ids);
}
