package com.medical.mapper;

import com.medical.entity.Orderitme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单项 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface OrderitmeMapper extends BaseMapper<Orderitme> {
        public List<Orderitme> selectJoinUser(User user);
}
