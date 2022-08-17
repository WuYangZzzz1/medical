package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.*;
import com.medical.service.impl.ConsultingServiceImpl;
import com.medical.service.impl.DoctorServiceImpl;
import com.medical.service.impl.UserServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 咨询表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/consulting")
public class ConsultingController {
    @Autowired
    private ConsultingServiceImpl consultingServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private DoctorServiceImpl doctorServiceImpl;

    /**
     * 我的病例
     * @param session
     * @return
     */
    @GetMapping("myconsulting")
    public Object myconsulting(HttpSession session){

        User user = (User) session.getAttribute("user");
        List<Consulting> myconsulting=new ArrayList<>();

        QueryWrapper<Consulting> consultingQueryWrapper=new QueryWrapper<>();
        consultingQueryWrapper.eq("u_id",user.getId());
        List<Consulting> consultings=consultingServiceImpl.list(consultingQueryWrapper);

        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("id",user.getId());



        for (Consulting consulting:consultings){
            if (consulting.getUId()==user.getId()) {
                // TODO: 2022/8/16 获取医生信息
                QueryWrapper<Doctor> doctorQueryWrapper=new QueryWrapper<>();
                doctorQueryWrapper.eq("id",consulting.getDoid());
                consulting.setDoctors(doctorServiceImpl.list(doctorQueryWrapper));

                myconsulting.add(consulting);

            }
        }

        return Result.success(myconsulting);
    }

}
