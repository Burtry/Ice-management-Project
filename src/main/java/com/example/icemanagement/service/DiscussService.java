package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;

public interface DiscussService {
    /**
     * 用户添加评论
     * @param spaceDiscussDTO
     */
    void createSpaceDiscuss(SpaceDiscussDTO spaceDiscussDTO);
}
