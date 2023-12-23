package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordMapper {

    /**
     * 查询租借记录
     * @param
     * @return
     */
    @Select("select * from icemanagement.equipment_rental_records order by rental_time desc")
    Page<LeaseRecords> page();


    @Select("select * from icemanagement.equipment_rental_records where id = #{id}")
    LeaseRecords getById(Long id);

    /**
     * 更新租借信息
     * @param reserveRecord
     */
    void update(LeaseRecords reserveRecord);
}
