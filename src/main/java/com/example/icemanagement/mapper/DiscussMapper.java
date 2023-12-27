package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.DiscussBySpace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiscussMapper {

    /**
     * 增加场地评论
     * @param discussBySpace
     */
    void createSpaceDiscuss(DiscussBySpace discussBySpace);
}
