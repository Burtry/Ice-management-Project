package com.example.icemanagement.pojo.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class EquipmentPageQueryDTOByName implements Serializable {

    //器材名称
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
