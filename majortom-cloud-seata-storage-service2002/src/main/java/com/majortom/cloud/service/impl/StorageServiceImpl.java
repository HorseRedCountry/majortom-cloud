package com.majortom.cloud.service.impl;

import com.majortom.cloud.dao.StorageDao;
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
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {

        log.info("--------->storage-service扣减库存 开始");
        storageDao.decrease(productId, count);
        log.info("--------->storage-service扣减库存 end");
    }
}
