package com.example.icemanagement.service;

import com.example.icemanagement.pojo.dto.AdminDTO;
import com.example.icemanagement.pojo.dto.AdminLoginDTO;
import com.example.icemanagement.pojo.entity.Admin;

public interface AdminService {
    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    Admin login(AdminLoginDTO adminLoginDTO);

    /**
     * 新增管理员
     * @param adminDTO
     */
    void insert(AdminDTO adminDTO);

    /**
     * 删除管理员
     * @param id
     */
    void delete(Long id);

    /**
     * 根据管理员id查询管理员
     * @param id
     * @return
     */
    Admin findById(Long id);
}
