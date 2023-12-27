package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.entity.DiscussBySpace;

import com.example.icemanagement.pojo.vo.SpaceDiscussVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DiscussMapper {

    /**
     * 增加场地评论
     * @param discussBySpace
     */
    void createSpaceDiscuss(DiscussBySpace discussBySpace);

    /**
     * 分页查看场地评论
     * @return
     */
    @Select("select ds.id," +
            "ds.create_time," +
            "s.space_name," +
            "u.user_name," +
            "ds.content " +
            "from icemanagement.discuss_space ds " +
            "left join icemanagement.space s on s.id = ds.space_id " +
            "left join icemanagement.user u on u.id = ds.user_id")
    Page<SpaceDiscussVO> listSpaceDiscuss();

}
