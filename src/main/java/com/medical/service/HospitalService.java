package com.medical.service;

import com.medical.entity.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 医院 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface HospitalService extends IService<Hospital> {

      boolean addHospital(Hospital hospital);

      boolean deleteHospital(int id);

      boolean updateHospital(Hospital hospital);

      List<Hospital> likeName( String hName);


}
