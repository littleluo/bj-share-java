package com.bj.jdk.math;

import java.math.BigDecimal;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/18 18:07
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class MathTest {

    public static void main(String[] args) {
        double dbl = 3.344;
        BigDecimal dclVal = new BigDecimal(dbl + "").add(new BigDecimal("0.001"));

        System.out.println("dclVal="+dclVal);

        System.out.println("ROUND_HALF_UP 四舍五入=" + dclVal.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println("ROUND_HALF_DOWN 向下舍入=" + dclVal.setScale(2, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("ROUND_DOWN 向下舍入=" + dclVal.setScale(2, BigDecimal.ROUND_DOWN));
    }
}
