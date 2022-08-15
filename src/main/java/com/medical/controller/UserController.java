package com.medical.controller;


import com.medical.entity.User;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        user.setName(HtmlUtils.htmlEscape(user.getName()));
        user.setPassword(HtmlUtils.htmlEscape(user.getPassword()));
        int register = userService.register(user);
        Map<String,Object> map = new HashMap<>();
        if (register>=0){
            map.put("data","注册成功");
        }
        else {
            map.put("data","注册失败");
        }
        return map;
    }
    @GetMapping("/register/{username}")
    public Map<String,Object> findByName(@PathVariable String username){
        User user = userService.findByUserName(username);
        Map<String,Object> map = new HashMap<>();
        if (user!=null){
            map.put("data","用户已存在");
        }
        else {
            map.put("data","未存在");
        }
        return map;
    }
    @PostMapping("/login")
    public Object loginUser(@RequestBody User user, HttpSession session){
        Map<String,Object> map = new HashMap<>();

        User login = userService.login(user.getUsername(), user.getPassword());
        if (login!=null){
            map.put("data","登录成功");
            if (login.getDoid()!=null){
                map.put("data","欢迎您医生");
            }
            session.setAttribute("user",login);
        }
        else {
            map.put("data","用户不存在,请先注册");
        }
        return map;
    }
}
