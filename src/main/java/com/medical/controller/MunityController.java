package com.medical.controller;


import Util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.medical.entity.Munity;
import com.medical.entity.User;
import com.medical.mapper.MunityMapper;
import com.medical.service.MunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 社区 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/munity")
public class MunityController {

    @Autowired
    MunityMapper munityMapper;

    @Autowired
    MunityService munityService;

    /**
     * 根据标题（subtitle）查询社区文章
     * @param munity
     * @return
     */
    @PostMapping("/SelectMunityLike")
    public Result SelectMunity(@RequestBody Munity munity){
        QueryWrapper<Munity> munityQueryWrapper=new QueryWrapper<>();
        munityQueryWrapper.like("subtitle",munity.getSubtitle());
        List<Munity >munityList=munityMapper.selectList(munityQueryWrapper);
        return  Result.success(munityList);
    }

    /**
     * 改变社区文章状态
     * @param id
     * @param munity
     * @return
     */
    @PostMapping("MunityOut")
    public Result MunityOut(@RequestParam("id")int id , Munity munity){
           UpdateWrapper<Munity> munityUpdateWrapper=new UpdateWrapper<>();
           munityUpdateWrapper.eq("id",id).set("c_state",munity.getCState());
           munityService.update(munityUpdateWrapper);
           return  Result.success(munity);
       }
}
