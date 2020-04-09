package com.bookmall.dao;

import com.bookmall.utils.CommonUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 接口通用的默认方法
 */
public interface Common<T> {
    /**
     * 获取多个Bean对象中指定属性的值，封装到一个set对象中
     *
     * @param beans
     * @param fieldName: 属性名
     * @param <E>       返回类型为泛型，即由接收值的变量类型所决定
     * @return 获取多个Bean对象中指定属性的值组成的Set集合，Set
     */
    default <E> Set<E> getBeansField(List<T> beans, String fieldName) {
        if (beans == null || beans.isEmpty()) {
            return null;
        }
        Set<E> set = new HashSet<>();
        String methodName = "get" + CommonUtils.capital2Upper(fieldName);
        try {

            Method method = beans.get(0).getClass().getMethod(methodName);
            for (T bean : beans) {
                Object ret = method.invoke(bean);
                set.add((E) ret);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("无此方法：" + fieldName);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return set;
    }
}
