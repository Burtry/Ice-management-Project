package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HistoryPageQueryDTO implements Serializable {

    //用户id
    private Long userId;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
