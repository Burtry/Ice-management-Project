package com.example.icemanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class IcemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcemanagementApplication.class, args);
        log.info("启动!!!!!");
    }

}


