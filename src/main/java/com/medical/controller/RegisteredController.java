package com.medical.controller;


import com.medical.entity.Registered;
import com.medical.mapper.RegisteredMapper;
import com.medical.service.impl.DepartmentServiceImpl;
import com.medical.service.impl.HospitalServiceImpl;
import com.medical.service.impl.RegisteredServiceImpl;
import com.medical.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 预约挂号 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/registered")
public class RegisteredController {
    @Resource
    HospitalServiceImpl hospitalService;
    @Resource
    DepartmentServiceImpl departmentServiceImpl;
    @Resource
    RegisteredServiceImpl registeredServiceImpl;

    @GetMapping("register")
    public R Registered(Integer id) {
        List<Registered> registereds = registeredServiceImpl.selectReg(id);
        if (registereds != null) {
            return R.ok().put("data", registereds);
        }
        return R.error("aa");
    }
}
