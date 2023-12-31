package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecordsPageQueryDTO implements Serializable {

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
