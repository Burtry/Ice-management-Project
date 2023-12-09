package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.SpaceDTO;

public interface SpaceService {
    /**
     * 新增场地
     * @param spaceDTO
     */
    void insert(SpaceDTO spaceDTO);
}
