package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 器材
 */
@Data
public class Equipment {
    private Long id;

    //器材名称
    private String equipmentName;
    //器材类型
    private String equipmentType;
    //器材规格
    private String specification;
    //器材数量
    private Integer number;
    //注意事项
    private String precautions;
    //描述
    private String equipmentDetail;
    //图片
    private String img;
    //创建时间
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
