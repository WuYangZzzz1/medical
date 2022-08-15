package com.medical.mapper;

import com.medical.entity.Orderitme;
import com.medical.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    List<Orders> selectUserJoinOrders();
}
