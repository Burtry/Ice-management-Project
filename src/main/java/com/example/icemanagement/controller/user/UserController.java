package com.example.icemanagement.controller.user;
import com.example.icemanagement.common.constant.JwtClaimsConstant;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.common.utils.JwtUtil;
import com.example.icemanagement.config.properties.JwtProperties;
import com.example.icemanagement.pojo.dto.UserLoginDTO;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.pojo.vo.AdminLoginVO;
import com.example.icemanagement.pojo.vo.UserLoginVO;
import com.example.icemanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private JwtProperties jwtProperties;


    @Operation(summary = "findGet请求")
    @GetMapping("/find")
    public User find(Long id) {
        log.info("用户查询,id:{}",id);
        return userService.findById(id);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<UserLoginVO> userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录:{}",userLoginDTO);
        User user = userService.userLogin(userLoginDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        //生成JWT令牌
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        //VO对象封装
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setId(user.getId());
        userLoginVO.setName(user.getName());
        userLoginVO.setUserName(user.getUserName());
        userLoginVO.setToken(token);
        return Result.success(userLoginVO);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册:{}",userRegisterDTO);
        userService.userRegister(userRegisterDTO);
        return Result.success();
    }

}
