package com.example.icemanagement.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EquipmentDiscussVO {

    //评论id
    private Long id;

    //创建时间
    private LocalDateTime createTime;

    //器材名称
    private String spaceName;

    //用户名称
    private String userName;

    //评论内容
    private String content;

}
