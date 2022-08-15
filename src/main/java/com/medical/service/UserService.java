package com.medical.service;

import com.medical.entity.Orders;
import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface UserService extends IService<User> {
    List<Orders> listOrdersByUserId(Integer id);
}
