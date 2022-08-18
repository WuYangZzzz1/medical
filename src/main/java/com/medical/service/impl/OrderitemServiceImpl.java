package com.medical.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Orderitem;
import com.medical.mapper.OrderitemMapper;
import com.medical.service.IOrderitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单项 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem> implements IOrderitemService {

    @Override
    public List<Orderitem> findByUid(Page<Orderitem> page, int uid) {
        return baseMapper.findByUid(page,uid);
    }
    
    @Override
    public List<Orderitme> listOrderitme(Orderitme orderitme) {
        return orderitmeMapper.listOrderitme(orderitme) ;
    }
}
