package com.medical.service.impl;

import com.medical.entity.Hospital;
import com.medical.mapper.HospitalMapper;
import com.medical.service.HospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 医院 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService {
  @Resource
  HospitalMapper hospitalMapper;

  @Override
  public boolean addHospital(Hospital hospital) {
    return hospitalMapper.add(hospital)>0;
  }

  @Override
  public boolean deleteHospital(int id) {
    return hospitalMapper.delete(id)>0;
  }

  @Override
  public boolean updateHospital(Hospital hospital) {
    return hospitalMapper.update(hospital)>0;
  }

  @Override
  public List<Hospital> likeName(String hName) {
    return hospitalMapper.Likes(hName);
  }


}
