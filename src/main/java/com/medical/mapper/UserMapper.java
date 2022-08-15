package com.medical.mapper;

import com.medical.entity.Orders;
import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Orders> listOrdersByUserId(Integer id);
}
