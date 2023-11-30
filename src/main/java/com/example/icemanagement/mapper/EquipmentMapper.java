package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentMapper {
    /**
     * 器材查询
     * @return
     */
    Page<Equipment> pageQuery();

    /**
     * 新增器材
     * @param equipment
     */
    @Insert("insert into icemanagement.equipment (create_time, equipment_name, equipment_type, specification, number, precautions, equipment_detial, img) VALUES " +
            "(#{createTime},#{equipmentName},#{equipmentType},#{specification},#{number},#{precautions},#{equipmentDetial},#{img})")
    void insert(Equipment equipment);
}
