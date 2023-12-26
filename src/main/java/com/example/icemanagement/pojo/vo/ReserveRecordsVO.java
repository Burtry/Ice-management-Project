package com.example.icemanagement.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveRecordsVO {

    //预约场地名称
    private String spaceName;

    //预约用户名(昵称)
    private String userName;

    //用户性别
    private String sex;

    //用户手机号
    private String phone;

    //用户身份证
    private String idNumber;

    //预约时间
    private LocalDateTime reserveTime;

    //预约时长
    private Integer duration;

    //备注
    private String remark;

    //创建时间
    private LocalDateTime createTime;
}
