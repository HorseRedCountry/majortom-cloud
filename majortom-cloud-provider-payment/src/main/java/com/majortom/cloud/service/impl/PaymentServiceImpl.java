package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.PaymentDao;
import com.majortom.cloud.eneity.Payment;
import com.majortom.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 22:24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
