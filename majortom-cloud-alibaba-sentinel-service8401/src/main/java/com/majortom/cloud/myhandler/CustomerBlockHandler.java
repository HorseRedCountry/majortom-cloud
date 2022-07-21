package com.majortom.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.majortom.cloud.pojo.eneity.CommonResult;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/21 12:23
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handlerException");
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义，global handlerException---------2");
    }
}
