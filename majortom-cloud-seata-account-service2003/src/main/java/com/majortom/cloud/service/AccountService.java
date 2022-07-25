package com.majortom.cloud.service;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/25 12:42
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
