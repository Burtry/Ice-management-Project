package com.example.icemanagement.controller.admin;
import com.example.icemanagement.common.constant.JwtClaimsConstant;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.common.utils.JwtUtil;
import com.example.icemanagement.config.properties.JwtProperties;
import com.example.icemanagement.pojo.dto.AdminDTO;
import com.example.icemanagement.pojo.dto.AdminLoginDTO;
import com.example.icemanagement.pojo.entity.Admin;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.pojo.vo.AdminLoginVO;
import com.example.icemanagement.service.AdminService;
import com.example.icemanagement.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtProperties jwtProperties;


    @Operation(summary = "根据id用户查询")
    @GetMapping("/findUser")
    public User findUser(Long id) {
        log.info("用户查询,id:{}",id);
        return userService.findById(id);
    }


    @Operation(summary = "根据id管理员查询")
    @GetMapping("/findAdmin")
    public Admin findAdmin(Long id) {
        log.info("管理员查询,id:{}",id);
        return adminService.findById(id);
    }


    @Operation(summary = "管理员登录")
    @PostMapping("/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理员登录：{}", adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, admin.getId());

        //生成JWT令牌
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        //VO对象封装
        AdminLoginVO adminLoginVO = new AdminLoginVO();
        adminLoginVO.setId(admin.getId());
        adminLoginVO.setName(admin.getName());
        adminLoginVO.setUserName(admin.getUsername());
        adminLoginVO.setToken(token);
        return Result.success(adminLoginVO);

    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @Operation(summary = "管理员退出")
    public Result<String> logout() {
        return Result.success();
    }


    @PostMapping("/insertAdmin")
    @Operation(summary = "新增管理员")
    public Result<Object> insert(@RequestBody AdminDTO adminDTO) {
        log.info("新增管理员:{}",adminDTO);
        adminService.insert(adminDTO);
        return Result.success();
    }

    @DeleteMapping()
    @ApiOperation("根据id删除管理员")
    @Operation(summary = "删除管理员")
    public Result delete(Long  id) {
        adminService.delete(id);
        return Result.success();
    }


    @PutMapping()
    @Operation(summary = "修改管理员信息")
    public Result update(@RequestBody AdminDTO adminDTO) {
        log.info("修改管理员信息");
        adminService.update(adminDTO);
        return Result.success();
    }

}
