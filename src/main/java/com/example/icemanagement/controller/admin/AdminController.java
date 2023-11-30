package com.example.icemanagement.controller.admin;
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
 * 管理端相关控制层
 */

@RestController
@Slf4j
@RequestMapping("/admin")
@Tag(name = "管理端")
/**
 * 管理端不用注册，由管理员进行添加员工
 */
public class AdminController {

    @Autowired
    private UserService userService;

    @Operation(summary = "findGet请求")
    @GetMapping("/find")
    public User find(Integer id) {
        log.info("用户查询,id:{}",id);
        return userService.findById(id);
    }


}
