package com.example.icemanagement.pojo.dto;

import lombok.Data;

@Data
public class EquipmentDiscussDTO {
    //器材id
    private Long equipmentId;

    //用户id
    private Long userId;

    //评论内容
    private String content;
}
