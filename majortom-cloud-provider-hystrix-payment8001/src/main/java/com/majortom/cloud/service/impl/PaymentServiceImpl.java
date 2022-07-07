package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.PaymentDao;
import com.majortom.cloud.pojo.eneity.Payment;
import com.majortom.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_OK,id:    " + id + "\t" + "***";
    }

    @Override
    public String paymentInfo_TIMEOUT(Integer id, int timeNumber) {
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_TIMEOUT,id:    " + id + "\t" + "***" + "耗时: " + timeNumber;
    }
}
