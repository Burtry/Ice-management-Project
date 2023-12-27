package com.example.icemanagement.pojo.dto;


import lombok.Data;

@Data
public class SpaceDiscussDTO {

    //场地id
    private Long spaceId;

    //用户id
    private Long userId;

    //评论内容
    private String content;
}
