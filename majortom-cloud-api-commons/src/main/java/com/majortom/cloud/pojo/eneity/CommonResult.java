package com.majortom.cloud.pojo.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *  订单统一返回体
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 21:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{

    /**
     * 编码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
