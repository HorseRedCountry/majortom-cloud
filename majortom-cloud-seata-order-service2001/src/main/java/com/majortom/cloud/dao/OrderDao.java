package com.majortom.cloud.dao;

import com.majortom.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/24 23:08
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status")Integer status);

}
