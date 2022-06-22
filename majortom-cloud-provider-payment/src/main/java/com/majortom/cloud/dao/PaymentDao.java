package com.majortom.cloud.dao;

import com.majortom.cloud.eneity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 22:02
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
