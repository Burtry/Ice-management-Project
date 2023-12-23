package com.example.icemanagement.mapper;

import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.pojo.entity.Space;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecordsMapper {

    /**
     * 查询租借记录
     * @param
     * @return
     */
    @Select("select * from icemanagement.equipment_rental_records order by rental_time desc")
    Page<LeaseRecords> leasePage();


    /**
     * 通过id查询租借记录
     * @param id
     * @return
     */
    @Select("select * from icemanagement.equipment_rental_records where id = #{id}")
    LeaseRecords leaseGetById(Long id);

    /**
     * 更新租借信息
     * @param reserveRecord
     */
    void leaseUpdate(LeaseRecords reserveRecord);


    /**
     * 分页查询预约记录
     * @return
     */
    @Select("select * from icemanagement.space_reserve_records order by reserve_time desc")
    Page<ReserveRecords> reservePage();

    /**
     * 根据id查询预约记录
     * @param id
     * @return
     */
    @Select("select * from icemanagement.space_reserve_records where id = #{id}")
    ReserveRecords reserveGetById(Long id);

    /**
     * 修改场地预约信息
     * @param reserveRecords
     */
    void reserveUpdate(ReserveRecords reserveRecords);
}
