package com.medical.mapper;

import com.medical.entity.Hospital;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 医院 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface HospitalMapper extends BaseMapper<Hospital> {

     int add(Hospital hospital);

     int delete(int id);

     int  update(Hospital hospital);

     List<Hospital> Likes(@RequestParam("h_name") String hName);

     //分页
     @Select(" select * from hospital  limit #{pageNum},#{pageSize}")
     List<Hospital> selectPage(Integer pageNum,Integer pageSize);
     //计数
     @Select("select count(*) from hospital")
     Integer selectTotal();
}
