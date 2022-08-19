package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Category;
import com.medical.service.impl.CategoryServiceImpl;
import com.medical.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 药品分类 前端控制器
 * </p >
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    /**
     * 添加分类
     * @param category
     * @return
     */
   @PostMapping("addCategory")
    public R addCategory(@RequestBody Category category){
        categoryServiceImpl.save(category);
        return R.ok();
   }

    /**
     * 修改分类
     * @param id
     * @param classes
     * @return
     * @throws Exception
     */
   @PutMapping("upCategory")
    public R upCategory(Integer id,String classes)throws Exception{
       UpdateWrapper<Category> categoryUpdateWrapper = new UpdateWrapper<>();
       categoryUpdateWrapper.eq("id",id).set("classes",classes);
       categoryServiceImpl.update(categoryUpdateWrapper);
       return R.ok();
   }

    /**
     * 删除分类
     * @param id
     * @return
     * @throws Exception
     */
   @DeleteMapping("delCategory")
    public R delCategory(Integer id)throws Exception{
       categoryServiceImpl.removeById(id);
       return R.ok();
   }

    /**
     * 查询分类
     * @return
     * @throws Exception
     */
   @GetMapping("categories")
    public R category()throws Exception{
       QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
       categoryServiceImpl.list(categoryQueryWrapper);
       return R.ok();
   }
}
