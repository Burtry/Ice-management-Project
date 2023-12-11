package com.example.icemanagement.service;


import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;

public interface ReserveService {

    /**
     * 分页查看租借记录
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    PageResult page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO);
}
