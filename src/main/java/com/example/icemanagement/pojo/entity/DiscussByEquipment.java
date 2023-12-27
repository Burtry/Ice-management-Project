package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscussByEquipment {

    //评论id
    private Long id;

    //创建时间
    private LocalDateTime createTime;

    //器材id
    private Long equipmentId;

    //用户id
    private Long userId;

    //评论内容
    private String content;

    //更新时间
    private LocalDateTime updateTime;
}
