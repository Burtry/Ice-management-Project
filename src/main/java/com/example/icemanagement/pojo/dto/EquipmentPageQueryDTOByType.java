package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EquipmentPageQueryDTOByType implements Serializable {

    //器材名称
    private String type;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
