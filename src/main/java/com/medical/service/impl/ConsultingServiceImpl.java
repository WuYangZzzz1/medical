package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Consulting;
import com.medical.mapper.ConsultingMapper;
import com.medical.service.ConsultingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 咨询表 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class ConsultingServiceImpl extends ServiceImpl<ConsultingMapper, Consulting> implements ConsultingService {
    public Boolean update(Consulting consulting){
        UpdateWrapper<Consulting> wrapper =new UpdateWrapper<>();
        wrapper.eq("id",consulting.getId()).set("describle",consulting.getDescrible()).set("c_state",consulting.getCState());
        int update = baseMapper.update(consulting, wrapper);
        return update>0;
    }
    public Consulting findById(Integer id){
        QueryWrapper<Consulting> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id).select("c_state","doid");
        Consulting consulting = baseMapper.selectOne(wrapper);
        return consulting;
    }
}
