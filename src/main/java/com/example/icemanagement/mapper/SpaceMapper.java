package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.SpacePageQueryDTO;
import com.example.icemanagement.pojo.entity.Space;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpaceMapper {
    /**
     * 新增场地
     * @param space
     */
    @Insert("insert into icemanagement.space (create_time, space_name, precautions, img, status, update_time) VALUES (#{createTime},#{spaceName},#{precautions},#{img},#{status},#{updateTime})")
    void insert(Space space);

    /**
     * 分页查询场地
     * @param spacePageQueryDTO
     * @return
     */
    Page<Space> pageQuery(SpacePageQueryDTO spacePageQueryDTO);

    /**
     * 批量删除场地
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 修改场地信息
     * @param space
     */
    void update(Space space);
}
