package com.medical.controller;


import Util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.medical.entity.Hospital;
import com.medical.entity.Vaccine;
import com.medical.entity.Warehouse;
import com.medical.mapper.HospitalMapper;
import com.medical.mapper.VaccineMapper;
import com.medical.mapper.WarehouseMapper;
import com.medical.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医院 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/hospital")
public class HospitalController {
  @Autowired
    HospitalService hospitalService;

    @Resource
    HospitalMapper hospitalMapper;

    @Autowired
    WarehouseMapper warehouseMapper;

    @Autowired
    VaccineMapper vaccineMapper;

    /**
     * 添加医院
     * @param hospital
     * @return
     */
    @PostMapping("/addHospital")
    public Result add(@RequestBody Hospital hospital){
        boolean hospitalList=hospitalService.addHospital(hospital);
        return Result.success(hospitalList);
    }

    /**
     * 删除医院
     * @param id
     * @return
     */
    @DeleteMapping("/deleteHospital")
    public Result delete(@RequestParam("id")int id){
        boolean delete=hospitalService.deleteHospital(id);
        return  Result.success(delete);
    }

    /**+
     * 修改医院信息
     * @param hospital
     * @return
     */
    @PostMapping("/updateHospital")
    public  Result update(@RequestBody Hospital hospital){
        boolean update=hospitalService.updateHospital(hospital);
        return  Result.success(update);
    }

    @GetMapping("/likeName")
    public  Result likeName(@RequestParam("h_name") String hName){
        List<Hospital> hospitalList=hospitalService.likeName(hName);
        return Result.success(hospitalList);
    }

//    分页
    @PostMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum =(pageNum -1)*pageSize;
        List<Hospital> data= hospitalMapper.selectPage(pageNum, pageSize);
        Integer total=   hospitalMapper.selectTotal();
        Map<String,Object> res= new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    /**
     * 查询医院疫苗
     * @param id
     * @return
     */
    @PostMapping("selectVaccine")
    public  Map<String,Object>selectVaccine(@RequestParam("id")int id){
        QueryWrapper<Warehouse> warehouseQueryWrapper=  new QueryWrapper<>();
        warehouseQueryWrapper.lambda().eq(Warehouse::getHid,id);
        Warehouse warehouse=warehouseMapper.selectOne(warehouseQueryWrapper);

        int id1=warehouse.getId();
        QueryWrapper<Vaccine> vaccineQueryWrapper=new QueryWrapper<>();
        warehouseQueryWrapper.lambda().eq(Warehouse::getHid,id1);
        Vaccine vaccine=vaccineMapper.selectOne(vaccineQueryWrapper);

        Map<String,Object> map=new HashMap<>();
        map.put("warehouse",warehouse);
        map.put("vaccine",vaccine);
        return map;

    }

}
