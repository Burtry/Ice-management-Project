package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.PageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.vo.SpaceDiscussVO;
import com.github.pagehelper.Page;

public interface DiscussService {
    /**
     * 用户添加评论
     * @param spaceDiscussDTO
     */
    void createSpaceDiscuss(SpaceDiscussDTO spaceDiscussDTO);

    /**
     * 分页查看场地评论
     * @param pageQueryDTO
     * @return
     */
    PageResult listSpaceDiscuss(PageQueryDTO pageQueryDTO);
}
