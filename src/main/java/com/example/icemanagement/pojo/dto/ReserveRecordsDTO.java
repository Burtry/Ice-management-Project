package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveRecordsDTO {
    //预约id
    private Long id;

    //用户id
    private Long userId;

    //场地id
    private Long spaceId;

    //预约时间
    private LocalDateTime reserveTime;

    //预约时长
    private Integer duration;

    //备注
    private String remark;

}
