package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.constant.PasswordConstant;
import com.example.icemanagement.common.exception.AccountExitException;
import com.example.icemanagement.common.exception.AccountNotFoundException;
import com.example.icemanagement.mapper.AdminMapper;
import com.example.icemanagement.pojo.dto.AdminDTO;
import com.example.icemanagement.pojo.dto.AdminLoginDTO;
import com.example.icemanagement.pojo.entity.Admin;
import com.example.icemanagement.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登录
     * @param adminLoginDTO
     */
    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        Admin admin = adminMapper.getByUsername(username);

        //处理各种异常情况（用户名不存在、密码不对）
        if (admin == null) {
            throw  new AccountNotFoundException("账号不存在");
        }
       // 解密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //密码对比
        if(!admin.getPassword().equals(password)) {
            //密码错误
            throw new AccountExitException("密码错误");
        }

        return admin;
    }

    /**
     * 新增管理员
     * @param adminDTO
     */
    @Override
    public void insert(AdminDTO adminDTO) {
        //先根据用户名查找管理员，如果查到了，表示此用户已存在，抛出账号存在异常，否则新增管理员
        Admin admin = adminMapper.findByUserName(adminDTO.getUsername());

        if (admin != null) {
            //存咋，抛出账号存在异常
            log.info("用户名存在，无法新增");
            throw new AccountExitException("账号已存在!");
        }
        admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        admin.setCreateTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        //设置初始密码，并进行md5加密
        admin.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));
        adminMapper.insert(admin);
    }

    /**
     * 删除管理员
     * @param id 管理员id
     */
    @Override
    public void delete(Long id) {
        adminMapper.delete(id);
    }

    /**
     * 根据id查询管理员
     * @param id
     * @return
     */
    @Override
    public Admin findById(Long id) {
        return adminMapper.findById(id);
    }

    /**
     * 修改管理员信息
     * @param adminDTO
     */
    @Override
    public void update(AdminDTO adminDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO,admin);
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.update(admin);

    }
}
