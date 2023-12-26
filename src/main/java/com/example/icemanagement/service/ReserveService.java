package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.dto.ReserveRecordsDTO;
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

    /**
     * 根据id修改场地状态
     * @param status
     * @param id
     */
    void updateByStatus(Integer status, Long id);


    /**
     * 用户端创建预约
     * @param reserveRecordsDTO
     */
    void createReserve(ReserveRecordsDTO reserveRecordsDTO);

    /**
     * 分页查看用户预约
     * @param recordsPageQueryDTO
     * @return
     */
    PageResult list(RecordsPageQueryDTO recordsPageQueryDTO);

}
