package com.example.icemanagement.service;


import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.HistoryPageQueryDTO;
import com.example.icemanagement.pojo.dto.LeaseRecordsDTO;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.example.icemanagement.pojo.vo.LeaseRecordsVO;

import java.util.List;

public interface LeaseService {

    /**
     * 分页查看租借记录
     * @param recordsPageQueryDTO
     * @return
     */
    PageResult page(RecordsPageQueryDTO recordsPageQueryDTO);

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

    /**
     * 根据用户id查看该用户的租借信息
     * @param userId
     * @return
     */
    List<LeaseRecordsVO> getByUserId(Long userId);

    /**
     * 用户租借历史记录查询
     * @param historyPageQueryDTO
     * @return
     */
    PageResult historyPage(HistoryPageQueryDTO historyPageQueryDTO);

    /**
     * 创建租借信息
     * @param leaseRecordsDTO
     */
    void createLease(LeaseRecordsDTO leaseRecordsDTO);

    /**
     * 用户取消租借
     * @param id
     */
    void cancel(Long id);

    /**
     * 修改租借信息
     * @param leaseRecordsDTO
     */
    void update(LeaseRecordsDTO leaseRecordsDTO);
}
