package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 注册  校验 用户名 是否 重复
     * @param username 用户名
     * @return true
     */
    public boolean isExist(String username) {
        User user=getBaseMapper().selectUsername(username);
        return null != user;
    }

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User login(String username,String password) {
        return userMapper.login(username,password);
    }


}
