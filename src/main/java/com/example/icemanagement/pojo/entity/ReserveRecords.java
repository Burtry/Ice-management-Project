package com.example.icemanagement.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveRecords {
    //租借记录id
    private Long id;

    //用户id
    private Long userId;

    //器材id
    private Long equipmentId;

    //租借时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rentalDatTime;

    //归还日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnDateTime;

    //租借记录更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //租借状态 0未租借，1已借出
    private Integer status;

}
