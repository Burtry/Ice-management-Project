package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaseRecords {
    //租借记录id
    private Long id;

    //用户id
    private Long userId;

    //器材id
    private Long equipmentId;

    //租借时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rentalTime;

    //归还日期
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;

    //租借记录更新时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //创建时间
    private LocalDateTime createTime;

    //租借状态
    private Integer status;

    //备注
    private String remark;

}
