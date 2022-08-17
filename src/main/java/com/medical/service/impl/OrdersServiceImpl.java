package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public  static final String waitPay="waitPay";
    public  static final String waitDelivery="waitDelivery";
    public static final String waitConfirm="waitConfirm";
    public static final String waitReview="waitReview";
    public static final String finish="finish";
    public static final String delete="delete";

    @Override
    public Orders findByUid(int uid) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("uid",uid);
        return baseMapper.selectById(uid);
    }
}
