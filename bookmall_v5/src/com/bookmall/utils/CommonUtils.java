package com.bookmall.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonUtils {
    public CommonUtils() {
    }

    /**
     * 生成in (set) 中元素?占位
     * 如：
     * in (?, ?, ?)，生成括号里的内容：?, ?, ?
     *
     * @param set
     * @return
     */
    public static String getBeanSetParamerts(Set set) {
        String paramertsStr = "";
        if (set == null) {
            return paramertsStr;
        }
        set.remove(null);
        int i = 0;
        for (Object e : set) {
            ++i;
            if (i == set.size()) {
                paramertsStr += "?";
            } else {
                paramertsStr += "?" + ", ";
            }
        }
        return paramertsStr;
    }

    /**
     * 字符串数组转 整数Set
     *
     * @param strArry
     * @return
     */
    public static Set<Integer> strArry2IntegerSet(String[] strArry) {
        Set<Integer> set = new HashSet<>();
        for (String s : strArry) {
            try {
                int i = Integer.parseInt(s.strip());
                set.add(i);
            } catch (NumberFormatException e) {
                System.out.println("字符串转数字失败");
                e.printStackTrace();
            }

        }
        return set;
    }

    ;

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String capital2Upper(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).
                    append(Character.toUpperCase(s.charAt(0))).
                    append(s.substring(1)).
                    toString();
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String capital2Lower(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).
                    append(Character.toLowerCase(s.charAt(0))).
                    append(s.substring(1)).
                    toString();
    }

    /**
     * 由字符串解析整数
     *
     * @param intStr
     * @param defaultVal 解析出错时返回该值
     * @return
     */
    public static int parseInt(String intStr, int defaultVal) {
        int ret = 0;
        try {
            ret = Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return defaultVal;
        }
        return ret;
    }

    /**
     * 由字符串解析double数字
     *
     * @param doubleStr
     * @param defaultVal 解析出错时返回该值
     * @return
     */
    public static double parseDouble(String doubleStr, double defaultVal) {
        double ret = 0;
        try {
            Double.parseDouble(doubleStr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return defaultVal;
        }
        return ret;
    }
}