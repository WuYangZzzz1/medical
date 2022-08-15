package com.medical.controller;



import com.medical.entity.Orders;
import com.medical.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    OrdersService ordersService;
    @GetMapping("/userByOrders")
    public Object selectUserJoinOrders(){
        return  ordersService.selectUserJoinOrders();
    }
}
