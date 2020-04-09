package com.bookmall.utils;

import com.bookmall.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Beanutils {
    /**
     * 把请求的所有参数，注入到bean实例对象中
     * 即把http请求中相应的参数值，调用bean实例相应的set方法，设置值
     * 注意参数名要与bean实例的的setXxx 方法名对应上
     *
     * 此方法缺点(不建议使用，)：
     *    与web层的耦合度高，因为需要传入request对象
     *
     * @param request
     * @param bean: bean实例对象
     * @param <T>
     * @return: 传入的bean实例对象
     */
    public static <T> T copyParams2Bean(HttpServletRequest request, T bean) {
        Map<String, String[]> paramsMap = request.getParameterMap();
        try {
            BeanUtils.populate(bean, paramsMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 把请求的所有参数组成的Map对象，注入到bean实例对象中
     * 即把http请求中相应的参数值，调用bean实例相应的set方法，设置值
     * 当Bean对象有很多参数时，是很方便的
     *
     * 该方法更通用
     *
     * @param paramsMap: http请求中参数组成的Map对象
     * @param bean: Bean对象
     * @param <T>: 泛型
     * @return: 传入的Bean对象
     */
    public static <T> T copyParams2Bean(Map paramsMap, T bean) {
        try {
            //paramsMap.forEach((k, v) -> {
            //    System.out.println(k + ": " + v);
            //});
            // System.out.println("bean===: " + bean);
            BeanUtils.populate(bean, paramsMap);
            // System.out.println("bean 填充后===: " + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /*
    // 测试
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("username", "jiji");
        map.put("password", "py123456");
//        map.put("action", "login");

        User user = Beanutils.copyParams2Bean(map, new User());
        System.out.println(user);
    }
    */
}
