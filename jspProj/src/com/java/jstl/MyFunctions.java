package com.java.jstl;

import java.time.LocalDate;

/**
 * 自定义jstl函数库
 */
public class MyFunctions {
    /**
     * 获取年份
     * @return
     */
    public static String getYear() {
        LocalDate date = LocalDate.now();
        return String.valueOf(date.getYear());
    }

    /**
     * 判断年龄是否成年了
     * @param age
     * @return
     *     true: 成年了
     *     false: 未成年
     */
    public static Boolean isAdult(int age) {
        return age >= 18 ? true : false;
    }
}
