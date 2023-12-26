package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.constant.PasswordConstant;
import com.example.icemanagement.common.exception.AccountExitException;
import com.example.icemanagement.common.exception.AccountNotFoundException;
import com.example.icemanagement.common.exception.PasswordErrorException;
import com.example.icemanagement.mapper.UserMapper;
import com.example.icemanagement.pojo.dto.UserLoginDTO;
import com.example.icemanagement.pojo.dto.UserRegisterDTO;
import com.example.icemanagement.pojo.dto.UserUpdateDTO;
import com.example.icemanagement.pojo.entity.Admin;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.pojo.vo.UserVO;
import com.example.icemanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
     * @return
     */
    @Override
    public User userLogin(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUserName();
        String password = userLoginDTO.getPassword();
        User user = userMapper.getByUsername(username);

        //处理各种异常情况（用户名不存在、密码不对）
        if (user == null) {
            throw  new AccountNotFoundException("用户不存在");
        }
        // 解密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //密码对比
        if(!user.getPassword().equals(password)) {
            //密码错误
            throw new AccountExitException("密码错误");
        }

        return user;

    }

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    @Override
    public void userRegister(UserRegisterDTO userRegisterDTO) {
        String userName = userRegisterDTO.getUserName();
        User user = userMapper.getByUsername(userName);
        //首先根据用户名来查询是否存在这个用户，如果存在，则抛出账号已存在异常
        if(user != null) {
            throw new AccountExitException("账号已存在");
        }
        //然后，不存在，检查两次密码是否一致，不一致则抛出密码不一致异常
        if (!Objects.equals(userRegisterDTO.getPassword(), userRegisterDTO.getPasswordAgain())) {
            throw new PasswordErrorException("密码不一致");
        }
        //创建新用户
        User newUser = new User();
        BeanUtils.copyProperties(userRegisterDTO,newUser);

        //对密码进行md5加密
        newUser.setPassword(DigestUtils.md5DigestAsHex(userRegisterDTO.getPassword().getBytes()));

        newUser.setCreateTime(LocalDateTime.now());
        newUser.setUpdateTime(LocalDateTime.now());
        userMapper.register(newUser);

    }

    /**
     * 根据id获取前台展示的用户数据
     * @param id 用户id
     * @return
     */
    @Override
    public UserVO getPersonById(Long id) {
        return userMapper.getUserVOById(id);
    }

    /**
     * 修改个人信息(修改时，先通过id获取此用户的信息，用于页面回显)
     * @param
     */
    @Override
    public void update(UserUpdateDTO userUpdateDTO) {

        User user = userMapper.getById(userUpdateDTO.getId());

        if (user == null) {
            throw new AccountNotFoundException("用户不存在！");
        }

        if (!Objects.equals(userUpdateDTO.getPassword(), userUpdateDTO.getPasswordAgain())) {
            throw new PasswordErrorException("密码不一致");
        }

        BeanUtils.copyProperties(userUpdateDTO,user);
        //密码加密
        user.setPassword(DigestUtils.md5DigestAsHex(userUpdateDTO.getPassword().getBytes()));

        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);

    }
}
