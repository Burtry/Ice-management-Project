package com.example.icemanagement.service;


import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.LeaseRecords;

public interface LeaseService {

    /**
     * 分页查看租借记录
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    PageResult page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO);

    /**
     * 修改租借状态
     * @param status
     */
    void updateByStatus(Integer status,Long id);

    /**
     * 根据id查询此条租借记录
     * @param id
     * @return
     */
    LeaseRecords getById(Long id);
}
