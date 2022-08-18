package com.medical.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Review;
import com.medical.entity.User;
import com.medical.service.ReviewService;
import com.medical.service.impl.ReviewServiceImpl;
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
 * 评论 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/review")
public class ReviewController {
@Autowired
ReviewServiceImpl reviewService;
    /**
    * 我的评论
    */
    @GetMapping("/getall")
    public Object getAll(HttpSession session,Long current,Long size){
    Page<Review> page = new Page<>(current,size);
    Map<String,Object> map = new HashMap<>();
    User user = (User) session.getAttribute("user");
    if (user==null){
        map.put("data","请先登录");
        return map;
    }
    List<Review> allByUid = reviewService.findAllByUid(page,user.getId());
    if (allByUid.size()>0){
        map.put("data",allByUid);
    }
    else {
        map.put("data","查询失败");
    }

    return map;
}
    

//    查询全部评论
    /**
     * 评论查询
     * @param id
     * @return
     */
    @PostMapping("/SelectReview")
    public Result SelectReview(@RequestParam("id")int id){
        QueryWrapper<Review> reviewQueryWrapper=new QueryWrapper<>();
        reviewQueryWrapper.eq("id",id);
        List<Review>reviewList=reviewService.list(reviewQueryWrapper);
        return Result.success(reviewList);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/DeleteReview")
    public Result DeleteReview(@RequestParam("id")int id){
        QueryWrapper<Review> reviewQueryWrapper=new QueryWrapper<>();
        reviewQueryWrapper.eq("id",id);
        boolean remove=reviewService.remove(reviewQueryWrapper);
        return Result.success(remove);

    }
}
