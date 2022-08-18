package com.medical.controller;


import com.medical.entity.Orders;
import com.medical.entity.User;
import com.medical.service.impl.OrderitmeServiceImpl;
import com.medical.service.impl.OrdersServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/orders")
public class OrdersController {
    @Autowired
    private OrdersServiceImpl ordersServiceImpl;

    /**
     * 我的订单
     * @param session
     * @return
     */
    @GetMapping("myOrder")
    public Object myOrder(HttpSession session){
        // TODO: 2022/8/12 判断是否登陆
        User users = (User) session.getAttribute("user");
        if (users==null){
            return Result.fail("未登录");
        }

        List<Orders> myOrders=new ArrayList<>();
        List<Orders> orders=ordersServiceImpl.list();
        for (Orders orders1:orders){
            if (orders1.getUid()==users.getId())
                myOrders.add(orders1);
        }

        return Result.success(myOrders);
    }
    
    /**
     * 改变订单状态
     * @param id
     * @param orders
     * @return
     */
    @PostMapping("updateOrderState")
     public Result updateOrderState(@RequestParam("id")int id,Orders orders){
        UpdateWrapper<Orders>ordersUpdateWrapper=new UpdateWrapper<>();
        ordersUpdateWrapper.eq("id",id).set("order_state",orders.getOrderState());
        ordersService.update(ordersUpdateWrapper);
        return Result.success();

    }

}
