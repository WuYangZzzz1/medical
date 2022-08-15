package com.medical.service;

import com.medical.entity.Vip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface IVipService extends IService<Vip> {
    int add(Vip vip);
    Vip findId(Vip vip);
}
