package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Vip;
import com.medical.mapper.VipMapper;
import com.medical.service.IVipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements IVipService {

    @Override
    public int add(Vip vip) {
        return baseMapper.insert(vip);
    }

    @Override
    public Vip findId(Vip vip) {
        QueryWrapper<Vip> wrapper = new QueryWrapper<>();
        wrapper.eq("register_date",vip.getRegisterDate());
        wrapper.select("id");
        return baseMapper.selectOne(wrapper);
    }


}
