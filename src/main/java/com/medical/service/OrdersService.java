package com.medical.service;

import com.medical.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface OrdersService extends IService<Orders> {
    
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    Orders findByUid(int uid);
}
