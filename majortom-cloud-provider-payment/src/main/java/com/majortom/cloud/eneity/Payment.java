package com.majortom.cloud.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 支付 实体类定义
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 21:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private Long id;

    private String serial;

}
