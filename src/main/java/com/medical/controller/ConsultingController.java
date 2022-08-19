package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.*;
import com.medical.service.impl.ConsultingServiceImpl;
import com.medical.service.impl.DoctorServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 修改（添加）医嘱
     * @param session
     * @param id
     * @param describle
     * @return
     */
    @GetMapping("/describle/{id}")
    public Object jieDa(HttpSession session, @PathVariable Integer id, String describle){

        Map<String,Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if (user==null){
            map.put("data","请先登录");
            return map;
        }
        Consulting byId = consultingServiceImpl.findById(id);

        if (!user.getDoid().equals(byId.getDoid())){
            map.put("data","该用户不是医生或不是对应的医生,不能解答");
            return map;
        }else {
            if (byId.getCState().equals("未解答")){
                byId.setId(id);
                byId.setCState("已解答");
                byId.setDescrible(describle);
                Boolean update = consultingServiceImpl.update(byId);
                map.put("data","解答成功");
            }
            else {
                map.put("data","咨询状态错误");
            }
        }
        return map;
    }
}
