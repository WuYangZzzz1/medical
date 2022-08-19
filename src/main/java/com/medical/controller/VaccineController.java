package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Vaccine;
import com.medical.service.impl.VaccineServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 疫苗信息 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/vaccine")
public class VaccineController {
    @Autowired
    private VaccineServiceImpl vaccineServiceImpl;

    /**
     * 修改疫苗库存数
     * @param wid 仓库id
     * @param number 疫苗数
     * @return
     */
    @PostMapping("updatenumber")
    public Object updatenumber(@RequestParam("wid") int wid,@RequestParam("number") int number){
        QueryWrapper<Vaccine> vaccineQueryWrapper=new QueryWrapper<>();
        vaccineQueryWrapper.eq("wid",wid);

        Vaccine vaccine=vaccineServiceImpl.getOne(vaccineQueryWrapper);

        if (vaccine.getNumber()==null||vaccine.getNumber()==0){
            vaccine.setNumber(0);
        }

        int oldNumber=vaccine.getNumber();

        UpdateWrapper<Vaccine> vaccineUpdateWrapper=new UpdateWrapper<>();
        number += oldNumber;
        vaccineUpdateWrapper.eq("wid",wid).set("number",number);
        vaccineServiceImpl.update(vaccineUpdateWrapper);

        return Result.success(vaccineServiceImpl.getOne(vaccineQueryWrapper));
    }

}
