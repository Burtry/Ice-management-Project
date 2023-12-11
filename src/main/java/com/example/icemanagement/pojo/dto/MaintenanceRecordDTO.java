package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 维护计划DTO
 */
@Data
public class MaintenanceRecordDTO {
    //维护记录id
    private Long id;

    //维护器材id
    private Long equipmentId;

    //计划维护日期
    private LocalDateTime maintenanceDate;

    //维护人员
    private String technician;

    //维护描述
    private String description;
}
