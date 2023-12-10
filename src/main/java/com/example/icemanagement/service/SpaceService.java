package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.SpaceDTO;
import com.example.icemanagement.pojo.dto.SpacePageQueryDTO;

import java.util.List;

public interface SpaceService {
    /**
     * 新增场地
     * @param spaceDTO
     */
    void insert(SpaceDTO spaceDTO);

    /**
     * 场地分页查询
     * @param spacePageQueryDTO
     * @return
     */
    PageResult pageQuery(SpacePageQueryDTO spacePageQueryDTO);

    /**
     * 批量删除场地
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 修改器材
     * @param spaceDTO
     */
    void update(SpaceDTO spaceDTO);
}
