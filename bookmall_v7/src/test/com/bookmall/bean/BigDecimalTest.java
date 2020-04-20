package test.com.bookmall.bean;

import java.math.BigDecimal;

/**
 * 浮点数，计算精度丢失问题
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        double d1 = 0.01,
                d2 = 0.06,
                d3;
        d3 = d1 + d2;
        System.out.println("d3 = " + d3); // 0.06999999999999999
        // 正确的结果是0.07，为什么不精确了？？？，原因是小数在计算机中的存储形式造成

        double d4 = 0.7;
        System.out.println("d4 * 3 = " + d4 * 3); // 2.0999999999999996
        // // 正确的结果是2.1，与期望值不同，精度丢失，这是什么鬼？

        BigDecimal bigDecimal = new BigDecimal(0.7);
        System.out.println("bigDecimal = " + bigDecimal); // 0.6999999999999999555910790149937383830547332763671875
        // 真确结果是0.7


        /*
        * double计算时精度丢失避免方法
        * 方法1：new BigDecimal(String val);
        * 方法2：BigDecimal.valueOf(double val);
        *
        * */
        BigDecimal b1 = new BigDecimal("0.7");
        BigDecimal b2 = new BigDecimal(3);
        System.out.println("b1 * b2 = " + b1.multiply(b2));

        BigDecimal b3 = BigDecimal.valueOf(0.7);
        System.out.println(b3);
    }
}
