package com.example.icemanagement.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaseRecordsVO {

    //借用器材名称
    private String equipmentName;

    //借用用户名(唯一)
    private String userName;

    //用户性别
    private String sex;

    //用户手机号
    private String phone;

    //用户身份证
    private String idNumber;

    //租借时间
    private LocalDateTime rentalTime;

    //归还日期
    private LocalDateTime returnTime;

    //备注
    private String remark;

    //创建时间
    private LocalDateTime createTime;

}
