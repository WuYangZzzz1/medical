package com.medical.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Orders;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
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
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public Object login(@RequestBody User user, HttpSession session) {
        User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("username",user.getUsername())
                .eq("password",user.getPassword()));
        Map<String,Object> map = new HashMap<>();
        if(user1 == null){
            map.put("code",500);
            map.put("msg","账号密码错误");
            return map;
        }else {
            map.put("code",200);
            map.put("msg","登录成功");
            session.setAttribute("user",user1);
            return map;
        }
    }

    @GetMapping("/listuser")
    public Object findByUser(){
        return userMapper.selectList(null);
    }
    @PutMapping("/update")
    public void updateByUser(@RequestBody User user){
        userMapper.updateById(user);
    }
    @PutMapping("/add")
    public void add(@RequestBody User user){
         userMapper.insert(user);
    }
    @GetMapping("/Page")
    public Object findPage(@RequestParam(defaultValue = "1")Integer pageNum,
                           @RequestParam(defaultValue = "10")Integer pageSize,
                           @RequestParam(defaultValue = "")String search){
        Page<User> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (search == null){
            lambdaQueryWrapper.like(User::getName,search);
        }
        return page;
    }
    @DeleteMapping("/delete")
    public  void deleteById(@RequestParam Integer id){
        userMapper.deleteById(id);
    }

    @GetMapping("/registered")
    public Object registered(@RequestBody User user){
        String username = user.getUsername();
        User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
        Map<String,Object> map = new HashMap<>();
        if (user1 == null){
            add(user);
            map.put("code",200);
            map.put("msg","注册成功");
            return map;
        }else{
            map.put("code",500);
            map.put("msg","注册失败");
            return map;
        }
    }
    @GetMapping("/likeUsername")
    public Object like(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId());
        queryWrapper.or();
        queryWrapper.like("username",user.getUsername());
        return userService.list(queryWrapper);
    }
    @GetMapping("/listOrdersByUserId")
    public Object listOrdersByUserId(@Param(value = "id")Integer id) {
        List<Orders> orders = userService.listOrdersByUserId(id);
        return orders;
    }
}
