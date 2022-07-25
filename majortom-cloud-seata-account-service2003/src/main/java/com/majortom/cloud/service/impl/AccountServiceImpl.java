package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.AccountDao;
import com.majortom.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {

        log.info("--------->account-service账户扣减 开始");
        accountDao.decrease(userId, money);
        log.info("--------->account-service账户扣减 end");
    }
}
