package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Drug;
import com.medical.entity.Orderitme;
import com.medical.entity.Orders;
import com.medical.entity.User;
import com.medical.mapper.OrderitmeMapper;
import com.medical.service.DrugService;
import com.medical.service.OrderitmeService;
import com.medical.service.OrdersService;
import com.medical.service.impl.OrdersServiceImpl;
import com.sun.scenario.effect.impl.sw.java.JSWBrightpassPeer;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单项 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/orderitme")
public class OrderitmeController {
    @Autowired
    OrderitmeService orderitmeService;
    @Autowired
    OrderitmeMapper orderitmeMapper;
    @Autowired
    OrdersService ordersService;
    @Autowired
    DrugService drugService;
    @GetMapping("/listuserby")
    public List<Orderitme> listOrderitme(User user){
        return orderitmeService.selectJoinUser(user);
    }
    @GetMapping("/selectJoinUser")
    public Object selectJoinUser(int drid, int num,HttpSession session){
        Drug byId = drugService.getById(drid);
        User user = (User) session.getAttribute("user");
        int oiid = 0;
        boolean found = false;
        List<Orderitme> orderitmeList = listOrderitme(user);
        for (Orderitme orderitme:orderitmeList){
            if (orderitme.getDrug().getId() == byId.getId()){
                orderitme.setNumber(orderitme.getNumber()+num);
                orderitmeService.update();
                found = true;
                oiid = 0;
                break;
            }
        }
        if (!found){
            Orderitme orderitme = new Orderitme();
            orderitme.setUser(user);
            orderitme.setNumber(num);
            orderitme.setDrug(byId);
            orderitmeService.save(orderitme);
            oiid = orderitme.getId();
        }
        return oiid;
    }
    @GetMapping("/listOrders")
    public Object listOrders(){
        return orderitmeMapper.selectList(null);
    }

}
