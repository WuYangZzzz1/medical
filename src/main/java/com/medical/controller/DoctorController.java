package com.medical.controller;


import Util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Doctor;
import com.medical.entity.Hospital;
import com.medical.entity.User;
import com.medical.mapper.DoctorMapper;
import com.medical.mapper.HospitalMapper;
import com.medical.service.DoctorService;
import com.medical.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baomidou.mybatisplus.core.toolkit.IdWorker.getId;

/**
 * <p>
 * 医生信息 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/doctor")
public class DoctorController {
    @Autowired
    DoctorServiceImpl doctorServiceImpl;

    @Autowired
    DoctorService doctorService;

    @Resource
    DoctorMapper doctorMapper;

    @Autowired
    HospitalMapper hospitalMapper;


    /**
     * 添加医生
     * @param doctor
     * @return
     */
    @PostMapping("/insert")
    public Object insert(@RequestBody Doctor doctor) {
        doctorServiceImpl.save(doctor);
        return Result.success("ok");
    }

    /**
     * 修改医生职称
     * @param doctor
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestBody Doctor doctor) {
        UpdateWrapper<Doctor> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", doctor.getId()).set("title", doctor.getTitle());
        doctorServiceImpl.update(updateWrapper);
        return Result.success("ok");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Object delete(@RequestParam("id") int id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        boolean remove = doctorService.remove(queryWrapper);
        return Result.success(remove);
    }

    /**
     * 通过职称（title）模糊查询
     * @param doctor
     * @return
     */
    @PostMapping("/selectLike")
    public Result selectLike(@RequestBody Doctor doctor) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("title", doctor.getTitle());
        List<Doctor> doctorList = doctorMapper.selectList(queryWrapper);
        return Result.success(doctorList);
    }

    //    分页
    @PostMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Doctor> data = doctorMapper.selectPage(pageNum, pageSize);
        Integer total = doctorMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    /**
     * 医生所在的医院
     * @param request
     * @return
     */
    @PostMapping("/selectDoctorByHospital")
    public Map<String,Object> selectDoctorByHospital(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user1");
        String username=user.getUsername();
        int doid = user.getDoid();
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(Doctor::getId, doid);
        Doctor doctor = doctorMapper.selectOne(queryWrapper);

        Integer hid = doctor.getHid();
        System.out.println("hid"+hid);
        QueryWrapper<Hospital> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.lambda().eq(Hospital::getId,hid);
        Hospital hospital=hospitalMapper.selectOne(queryWrapper1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",username);
        map.put("doctor",doctor);
        map.put("hospital",hospital);
        return map;
    }

}
