package com.majortom.cloud.service;

import com.majortom.cloud.eneity.Payment;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 22:23
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
