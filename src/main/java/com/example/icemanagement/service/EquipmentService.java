package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByType;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EquipmentService {

    /**
     * 分页器材查询
     * @return
     */
    PageResult pageQuery(EquipmentPageQueryDTO equipmentPageQueryDTO);

    /**
     * 新增器材
     * @param
     */
    void insert(EquipmentDTO equipmentDTO);

    /**
     * 根据ids删除器材
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据类型分页查询器材
     * @param type
     * @return
     */
    PageResult pageByType(EquipmentPageQueryDTOByType type);

    /**
     * 根据id查询器材
     * @param id
     * @return
     */
    Equipment getById(Long id);

    /**
     * 修改器材
     * @param equipmentDTO
     */
    void update(EquipmentDTO equipmentDTO);
}
