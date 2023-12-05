package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 器材
 */
@Data
public class EquipmentDTO {
    private Long id;
    //器材名称
    private String equipmentName;
    //器材类型
    private String equipmentType;
    //器材状态
    private Integer status;
    //器材规格
    private String specification;
    //注意事项
    private String precautions;
    //器材数量
    private Integer number;
    //描述
    private String equipmentDetail;
    //图片
    private String img;
}
