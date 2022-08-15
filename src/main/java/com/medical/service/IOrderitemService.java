package com.medical.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Orderitem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单项 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
public interface IOrderitemService extends IService<Orderitem> {
        List<Orderitem> findByUid(Page<Orderitem> page,int uid);
}
