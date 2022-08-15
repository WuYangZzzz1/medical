package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Concern;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import com.medical.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 关注 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/concern")
public class ConcernController {


    @Resource
    ConcernMapper concernMapper;

    @GetMapping("selectConcernJoinUser")
    public User selectConcern(@RequestBody User user) {

        User users = concernMapper.selectConcernJoinUser(user.getId());
        return users;
    }

}
