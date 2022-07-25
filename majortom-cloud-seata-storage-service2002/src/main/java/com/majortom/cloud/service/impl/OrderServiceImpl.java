package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.OrderDao;
import com.majortom.cloud.domain.Storage;
import com.majortom.cloud.service.AccountSrvice;
import com.majortom.cloud.service.OrderService;
import com.majortom.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/25 12:41
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountSrvice accountSrvice;

    @Override
    public void create(Storage storage) {
        log.info("--------开始新建订单--------");
        orderDao.create(storage);

        log.info("-------->订单微服务开始调用库存，做扣减");
        storageService.decrease(storage.getProductId(), storage.getCount());
        log.info("-------->订单微服务调用库存，做扣减end");

        log.info("-------->订单微服务开始调用账户，做扣减");
        accountSrvice.decrease(storage.getUserId(), storage.getMoney());
        log.info("-------->订单微服务调用账户，做扣减end");

        log.info("-------->修改订单状态，开始");
        orderDao.update(storage.getUserId(), 0);
        log.info("-------->修改订单状态，end");

        log.info("--------下订单结束--------");
    }
}
