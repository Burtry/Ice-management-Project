package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByName;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByType;
import com.example.icemanagement.pojo.entity.Equipment;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EquipmentMapper {
    /**
     * 器材查询
     * @return
     */
    Page<Equipment> pageQuery(EquipmentPageQueryDTOByName equipmentPageQueryDTOByName);

    /**
     * 新增器材
     * @param equipment
     */
    @Insert("insert into icemanagement.equipment (create_time, equipment_name, equipment_type, specification, number, precautions, equipment_detail, img, update_time) VALUES " +
            "(#{createTime},#{equipmentName},#{equipmentType},#{specification},#{number},#{precautions},#{equipmentDetail},#{img},#{updateTime})")
    void insert(Equipment equipment);

    /**
     * 批量删除器材
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据类型查询器材
     * @param equipmentPageQueryDTOByType
     * @return
     */
    Page<Equipment> pageByType(EquipmentPageQueryDTOByType equipmentPageQueryDTOByType);

    /**
     * 根据id查询器材
     * @param id
     * @return
     */
    @Select("select * from icemanagement.equipment where id = #{id}")
    Equipment getById(Long id);

    /**
     * 修改器材信息
     * @param equipment
     */
    void update(Equipment equipment);
}
