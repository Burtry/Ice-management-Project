package com.example.icemanagement.controller.user;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.UserLoginDTO;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户端相关控制层
 */

@RestController
@Slf4j
@RequestMapping("/user")
@Tag(name = "用户端")
public class UserController {
    @Autowired
    private UserService userService;



    @Operation(summary = "findGet请求")
    @GetMapping("/find")
    public User find(Integer id) {
        log.info("用户查询,id:{}",id);
        return userService.findById(id);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<User> userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录");
        String userAccount = userLoginDTO.getUserAccount();
        String userPassword = userLoginDTO.getUserPassword();
        User user = userService.userLogin(userAccount, userPassword);
        return Result.success(user);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册");
        userService.userRegister(userRegisterDTO);
        return Result.success();
    }

}
