package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaseRecordsDTO {
    //租借id
    private Long id;

    //用户id
    private Long userId;

    //租借器材id
    private Long equipmentId;

    //租借时间
    private LocalDateTime rentalTime;

    //归还时间
    private LocalDateTime returnTime;

    //备注
    private String remark;

}
