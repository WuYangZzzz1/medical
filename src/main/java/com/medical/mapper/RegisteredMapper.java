package com.medical.mapper;

import com.medical.entity.Registered;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 预约挂号 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface RegisteredMapper extends BaseMapper<Registered> {

    List<Registered> getById(Integer id);
}
