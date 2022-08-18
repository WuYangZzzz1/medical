package com.medical.mapper;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 医生信息 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DoctorMapper extends BaseMapper<Doctor> {

    //分页
    @Select(" select * from doctor  limit #{pageNum},#{pageSize}")
    List<Doctor> selectPage(Integer pageNum, Integer pageSize);
    //计数
    @Select("select count(*) from doctor ")
    Integer selectTotal();
}
