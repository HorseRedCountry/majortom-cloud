package com.majortom.cloud.dao;

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
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count")Integer count);

}
