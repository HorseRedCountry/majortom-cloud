package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.OrderDao;
import com.majortom.cloud.domain.Order;
import com.majortom.cloud.service.AccountSrvice;
import com.majortom.cloud.service.OrderService;
import com.majortom.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional(name = "mt-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("--------开始新建订单--------");
        orderDao.create(order);

        log.info("-------->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------->订单微服务调用库存，做扣减end");

        log.info("-------->订单微服务开始调用账户，做扣减");
        accountSrvice.decrease(order.getUserId(), order.getMoney());
        log.info("-------->订单微服务调用账户，做扣减end");

        log.info("-------->修改订单状态，开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-------->修改订单状态，end");

        log.info("--------下订单结束--------");
    }
}
