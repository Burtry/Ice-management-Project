package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;

public interface ReserveService {
    /**
     * 分页查询场地预约记录
     * @param recordsPageQueryDTO
     * @return
     */
    PageResult page(RecordsPageQueryDTO recordsPageQueryDTO);

    /**
     * 根据id查询场地预约记录
     * @param id
     * @return
     */
    ReserveRecords getById(Long id);
}
