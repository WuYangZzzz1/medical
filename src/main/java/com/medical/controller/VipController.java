package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.service.IVipService;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/vip")
public class VipController {
    @Autowired
    IVipService iVipService;
    @Autowired
    UserService userService;

    // todo
@PostMapping("/addvip")
    public Map<String,Object> addVip(@RequestBody Vip vip, HttpSession session) {
    Map<String, Object> map = new HashMap<>();
    User user = (User) session.getAttribute("user");
    if (user==null){
        map.put("data","请先登录");
        return map;   }
    vip.setRegisterDate(LocalDateTime.now());
    User byId = userService.findById(user.getId());
    if (byId != null) {
        map.put("data", "用户已经是会员");
    } else {
        int add = iVipService.add(vip);
        if (add > 0) {
            map.put("data", "会员注册成功");
        } else {
            map.put("data", "会员注册失败");
        }
        Vip id = iVipService.findId(vip);
        user.setVipId(id.getId());
        userService.updateById(user);
    }
    return map;
    }
    
}
