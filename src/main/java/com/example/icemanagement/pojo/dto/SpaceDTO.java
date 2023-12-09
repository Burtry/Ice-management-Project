package com.example.icemanagement.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SpaceDTO {
    private Long id;

    private int status;

    private String spaceName;

    private String precautions;

    private String img;

}
