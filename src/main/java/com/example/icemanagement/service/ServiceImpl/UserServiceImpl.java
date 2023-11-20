package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.mapper.UserMapper;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
