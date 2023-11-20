package com.example.icemanagement.controller;

import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/find")
@Tag(name = "find参数")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "findGet请求")
    @GetMapping("")
    public User find(Integer id) {
        log.info("用户查询,id:{}",id);
        return userService.findById(id);
    }


}
