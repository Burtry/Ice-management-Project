package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MaintenanceRecord {
    //维护记录id
    private Long id;

    //器材id
    private Long equipmentId;

    //维护日期
    private LocalDateTime maintenanceDate;

    //维护人员
    private String technician;

    //维护描述
    private String description;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;


}
