package com.medical.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Orderitem;
import com.medical.entity.User;
import com.medical.service.IOrderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单项 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
@RestController
@RequestMapping("/medical/orderitem")
public class OrderitemController {
    @Autowired
    IOrderitemService orderitemService;
    //查询购物车
        @GetMapping("/getorderitem")
    public Map<String,Object> getOrderItem(HttpSession session,Long current,Long size){
            Page<Orderitem> page = new Page<>(current,size);
        Map<String,Object> map = new HashMap<>();
            User user = (User) session.getAttribute("user");
            if (user==null){
                map.put("data","请先登录");
                return map;   }

        List<Orderitem> byUid = orderitemService.findByUid(page,user.getId());
        float totalPrice=0;
        for (Orderitem oi : byUid) {
             totalPrice+=oi.getNumber()* oi.getDrug().getPrice();
            oi.setTotalPrice(totalPrice);
        }

        if (byUid.size()>0){
            map.put("data",byUid);
        }
        else map.put("data","查询失败");
        return map;
    }
    
    /**
     * 通过订单项查询订单
     * @param orderitme
     * @return
     */
    @PostMapping("selectOrder")
    public Result selectOrder(Orderitme orderitme){
        List<Orderitme> orderitmes = orderitmeService.listOrderitme(orderitme);
        return Result.success(orderitmes);
    }

}
