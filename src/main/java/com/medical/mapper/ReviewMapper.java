package com.medical.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ReviewMapper extends BaseMapper<Review> {
    List<Review> findAllByUid(Page<Review> page, @Param("uid") int id);
}
