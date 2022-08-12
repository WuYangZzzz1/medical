package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username,String password);
}
