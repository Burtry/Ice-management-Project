package com.example.icemanagement.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
