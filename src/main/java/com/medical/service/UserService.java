package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface UserService extends IService<User> {
    User loginUser(String name,String password);


    /**
     * 用户登录
     */
    int register(User user);
   User findByUserName(String username);
   User findById(int id);
   User login(String username,String password);
}
