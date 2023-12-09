package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.Space;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpaceMapper {
    @Insert("insert into icemanagement.space (create_time, space_name, precautions, img, status, update_time) VALUES (#{createTime},#{spaceName},#{precautions},#{img},#{status},#{updateTime})")
    void insert(Space space);
}
