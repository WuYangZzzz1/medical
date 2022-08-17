package com.medical.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Orderitem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单项 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
public interface OrderitemMapper extends BaseMapper<Orderitem> {
    List<Orderitem> findByUid(Page<Orderitem> page, @Param("uid") int uid);
}
