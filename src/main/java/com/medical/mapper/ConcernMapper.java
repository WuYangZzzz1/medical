package com.medical.mapper;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;

/**
 * <p>
 * 关注 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ConcernMapper extends BaseMapper<Concern> {


    User selectConcernJoinUser(int id);
}
