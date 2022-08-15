package com.medical.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Orderitme;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.Orders;
import com.medical.entity.User;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.ibatis.annotations.Param;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * <p>
 * 订单项 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface OrderitmeService extends IService<Orderitme> {
    List<Orderitme> selectJoinUser(User user);

}
