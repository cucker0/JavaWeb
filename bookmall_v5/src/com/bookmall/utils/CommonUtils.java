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
     * @param set
     * @return
     */
    public static String getBeanSetParamerts(Set set) {
        set.remove(null);
        String paramertsStr = "";
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

}