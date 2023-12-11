package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordMapper {

    /**
     * 查询租借记录
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    @Select("select * from icemanagement.equipment_rental_records order by rental_time desc")
    Page<ReserveRecords> page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO);

}
