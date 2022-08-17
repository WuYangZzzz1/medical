package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public interface UserMapper extends BaseMapper<User> {
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username, String password);

    /**
     * 用于校验用户名是否重复
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    User selectUsername(String username);
}
