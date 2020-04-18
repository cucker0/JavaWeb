package com.bookmall.utils;

import com.bookmall.bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

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
    public static Set<Integer> strArry2IntegerSet(String[] strArry, Set<Integer> defaultVal) {
        if (strArry == null) {
            return defaultVal;
        }
        Set<Integer> set = new HashSet<>();
        for (String s : strArry) {
            try {
                int i = Integer.parseInt(s.strip());
                set.add(i);
            } catch (NumberFormatException e) {
                System.out.println("字符串转数字失败");
                // e.printStackTrace();
                return defaultVal;
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
        if (intStr == null) {
            return  defaultVal;
        }
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
            ret = Double.parseDouble(doubleStr);
        } catch (NumberFormatException | NullPointerException e) {
            //e.printStackTrace();
            return defaultVal;
        }
        return ret;
    }

    public static boolean parseBoolean(String booleanStr, boolean defaultVal) {
        boolean ret = false;
        try {
            ret = Boolean.parseBoolean(booleanStr);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultVal;
        }
        return ret;
    }

    /**
     * 生成订单id
     *
     * @return
     */
    public static String generateOrderId(int userId) {
        // 订单id格式：当前时间 + "_" + 用户id
        return System.currentTimeMillis() + "_" + userId;
    }

    public static String generateOrderId() {
        int defaultUserId = 0;
        return generateOrderId(defaultUserId);
    }

    // 获取购物车，没有则创建
    public static Cart getCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if ( cart == null ) {
            cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            Cookie ck = new Cookie("JSESSIONID", session.getId());
            ck.setMaxAge(60 * 60 * 24 * 5);
            response.addCookie(ck);
        }
        return cart;
    }

    /**
     * 反转LinkedHashMap对象的元素排序
     *
     * @param map LinkedHashMap对象
     * @param reverseSelf 返回新map对象还是新map对象
     *                    true: 反转原LinkedHashMap对象并返回
     *                    false: 返回新map对象
     * @param <K> map的key泛型
     * @param <V> map的value泛型
     * @return 与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     */
    public static <K, V> LinkedHashMap<K, V> reverse(LinkedHashMap<K,V> map, boolean reverseSelf) {
        LinkedHashMap<K, V> reverseMap = new LinkedHashMap<>();
        ListIterator<Map.Entry<K, V>> iterator = new ArrayList<>(map.entrySet())
                .listIterator(map.entrySet().size());
        while (iterator.hasPrevious()) {
            Map.Entry<K, V> entry = iterator.previous();
            reverseMap.put(entry.getKey(), entry.getValue());
        }
        if (reverseSelf) {
            map.clear();
            map.putAll(reverseMap);
            return map;
        }
        return reverseMap;
    }

    /**
     * 返回一个与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     * 返回的LinkedHashMap对象是一个新对象，不是原LinkedHashMap对象
     *
     * @param map LinkedHashMap对象
     * @param <K> map的key泛型
     * @param <V> map的value泛型
     * @return 与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     */
    public static <K, V> LinkedHashMap<K, V> reverse(LinkedHashMap<K,V> map) {
        return reverse(map, false);
    }
}