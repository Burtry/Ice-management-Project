package com.example.icemanagement.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Space {
    private Long id;

    private LocalDateTime createTime;

    private int status;

    private String spaceName;

    private String precautions;

    private String img;

    private LocalDateTime updateTime;
}
