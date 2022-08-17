package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.User;
import com.medical.service.UserService;
import com.medical.service.impl.UserServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;

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
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param user 用户
     * @return 注册成功
     */
    @PostMapping("registered")
    public Result registered(@RequestBody User user){
        String username=user.getUsername();

        username=HtmlUtils.htmlEscape(username);

        // TODO: 2022/8/12 生成注册时间
        user.setEnrollDate(new Date());

        // TODO: 2022/8/12 判断用户名是否已经存在
        boolean exist=userServiceImpl.isExist(username);
        if (exist){
            String message="用户名已使用，请重新输入用户名";
            return Result.fail(message);
        }

        userServiceImpl.save(user);
        return Result.success("注册成功!");
    }

    /**
     * 登陆接口
     * @param user 用户
     * @param session 会话 储存用户信息
     * @return 登陆成功
     */
    @PostMapping("login")
    public Result login(@RequestBody User user,HttpSession session){
        String username=user.getUsername();
        String password=user.getPassword();

        User user1=userService.login(username,password);

        if (user1 == null){
            return Result.fail("登陆失败");
        }

        session.setAttribute("user",user1);
        return Result.success("登陆成功");
    }

    /**
     * 通过 用户名/账号 修改密码
     * @param user 用户
     * @param session 会话
     * @return user
     */
    @PutMapping("updatePassword")
    public Object updatePassword(@RequestBody User user,HttpSession session){
        User user1=(User) session.getAttribute("user");
        UpdateWrapper<User> userUpdateWrapper=new UpdateWrapper<>();
        userUpdateWrapper.eq("username",user.getUsername()).set("password",user.getPassword());
        userServiceImpl.update(userUpdateWrapper);
        return Result.success(user);
    }

    /**
     * 查询收货地址
     * @param session 会话
     * @return 地址
     */
    @GetMapping("harvestAddress")
    public Object getHarvestAddress(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return Result.fail("未登录");
        }
        return Result.success(user.getHarvestAddress());
    }

    /**
     * 添加地址/修改地址/删除地址
     * @param user 用户
     * @param session 会话
     * @return user信息
     */
    @PostMapping("harvestAddress")
    public Object addHarvestAddress(@RequestBody User user, HttpSession session){
        User user1 = (User) session.getAttribute("user");
        if (user1==null){
            return Result.fail("未登录");
        }
        user1.setHarvestAddress(user.getHarvestAddress());
        return Result.success(user);
    }

}
