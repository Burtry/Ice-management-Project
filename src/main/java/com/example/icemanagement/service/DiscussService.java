package com.example.icemanagement.service;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.pojo.dto.EquipmentDiscussDTO;
import com.example.icemanagement.pojo.dto.PageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.vo.SpaceDiscussVO;
import com.github.pagehelper.Page;

public interface DiscussService {
    /**
     * 用户添加场地评论
     * @param spaceDiscussDTO
     */
    void createSpaceDiscuss(SpaceDiscussDTO spaceDiscussDTO);

    /**
     * 分页查看场地评论
     * @param pageQueryDTO
     * @return
     */
    PageResult listSpaceDiscuss(PageQueryDTO pageQueryDTO);

    /**
     * 用户添加器材评论
     * @param equipmentDiscussDTO
     */
    void createEquipmentDiscuss(EquipmentDiscussDTO equipmentDiscussDTO);

    /**
     * 分页查看器材评论
     * @param pageQueryDTO
     * @return
     */
    PageResult listEquipmentDiscuss(PageQueryDTO pageQueryDTO);

    /**
     * 管理员删除场地评论
     * @param id
     */
    void deleteSpaceDiscussById(Long id);

    /**
     * 管理员删除器材评论
     * @param id
     */
    void deleteEquipmentDiscussById(Long id);
}
