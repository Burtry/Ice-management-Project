package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;

public interface EquipmentService {

    /**
     * 器材查询
     * @return
     */
    PageResult pageQuery(EquipmentPageQueryDTO equipmentPageQueryDTO);

    /**
     * 新增器材
     * @param
     */
    void insert(EquipmentDTO equipmentDTO);
}
