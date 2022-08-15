package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Override
    public Orders findByUid(int uid) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("uid",uid);
        return baseMapper.selectById(uid);
    }
}
