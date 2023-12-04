package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.AccountExitException;
import com.example.icemanagement.common.exception.PasswordErrorException;
import com.example.icemanagement.mapper.UserMapper;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    @Override
    public User userLogin(String userAccount, String userPassword) {

        User user = userMapper.getByAccountAndPassword(userAccount,userPassword);

        if (user == null) {
            log.info("登录失败，账号或密码错误！");
            return null;
        }
        return  user;

    }

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    @Override
    public void userRegister(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.getByAccountAndPassword(userRegisterDTO.getAccount(), userRegisterDTO.getPassword());
        if (!Objects.equals(userRegisterDTO.getPassword(), userRegisterDTO.getPasswordAgain())) {
            throw new PasswordErrorException("密码不一致");
        }

        if(user != null) {
            throw new AccountExitException("账号已存在");
        }

        User newUSer = new User();
        BeanUtils.copyProperties(userRegisterDTO,newUSer);
        newUSer.setCreateTime(LocalDateTime.now());
        newUSer.setUpdateTime(LocalDateTime.now());
        userMapper.register(newUSer);

    }
}
