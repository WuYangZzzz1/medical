package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Drug;
import com.medical.entity.User;
import com.medical.service.impl.DepartmentServiceImpl;
import com.medical.service.impl.DrugServiceImpl;
import com.medical.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * <p>
 * 药品 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/drug")
public class DrugController {
    @Autowired
    DrugServiceImpl drugServiceImpl;

    /**
     * 添加药品
     * @param drug
     * @return
     * @throws Exception
     */
  @GetMapping("addDrug")
    public R drug(Drug drug)throws Exception{
       drugServiceImpl.save(drug);
       return R.ok();
  }

    /**
     * 修改药品
     * @param id 药品id
     * @param dname 药品名称
     * @return
     * @throws Exception
     */
  @PutMapping("upDrug")
    public R upDrug(int id,String dname)throws Exception{

      UpdateWrapper<Drug> drugUpdateWrapper = new UpdateWrapper<>();

      drugUpdateWrapper.eq("id",id).set("d_name",dname);

          drugServiceImpl.update(drugUpdateWrapper);
          return R.ok();

  }

    /**
     * 删除药品
     * @param id 药品id
     * @return
     * @throws Exception
     */
  @DeleteMapping("delDrug")
    public R delDrug(int id)throws Exception{
      drugServiceImpl.removeById(id);
      return R.ok();
  }

    /**
     * 添加药
     * @param dname 药名
     * @param stock 库存
     * @return  添加成功
     * @throws Exception
     */
 @PutMapping("selDrug")
    public R selDrug(String dname,Integer stock)throws Exception{
      QueryWrapper<Drug> drugQueryWrapper = new QueryWrapper<>();
      drugQueryWrapper.eq("d_name",dname);
      Drug drug=drugServiceImpl.getOne(drugQueryWrapper);
      if (drug.getStock()==null){
          drug.setStock(0);
      }
      int stock1=stock+drug.getStock();
     UpdateWrapper<Drug> drugUpdateWrapper = new UpdateWrapper<>();
     drugUpdateWrapper.eq("d_name",dname).set("stock",stock1);
     drugServiceImpl.update(drugUpdateWrapper);
     return R.ok();
 }
}
