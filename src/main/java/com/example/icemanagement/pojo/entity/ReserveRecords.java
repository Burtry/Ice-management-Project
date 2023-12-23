package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveRecords {
    //预约id
    private Long id;

    //用户id
    private Long userId;

    //场地id
    private Long spaceId;

    //预约时间      ->相当于创建时间
    private LocalDateTime reserveTime;

    //更新时间
    private LocalDateTime updateTime;

    //租借状态 0未租借，1已借出
    private Integer status;
}
