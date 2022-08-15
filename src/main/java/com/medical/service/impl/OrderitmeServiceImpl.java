package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Orderitme;
import com.medical.entity.Orders;
import com.medical.entity.User;
import com.medical.mapper.OrderitmeMapper;
import com.medical.service.OrderitmeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 订单项 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class OrderitmeServiceImpl extends ServiceImpl<OrderitmeMapper, Orderitme> implements OrderitmeService {
    @Autowired
    OrderitmeMapper orderitmeMapper;


    @Override
    public List<Orderitme> selectJoinUser(User user) {
        return orderitmeMapper.selectJoinUser(user) ;
    }
}
