package com.java.www;

import org.junit.Test;

import java.util.Locale;

public class LocaleTest {
    @Test
    public void getAllLocales() {
        Locale[] locales = Locale.getAvailableLocales();
        // 打印所有的地区信息
        for (Locale locale : locales) {
            System.out.println(locale);
        }
    }

    @Test
    public void getDefaultLocale() {
        Locale locale = Locale.getDefault();
        System.out.println(locale);  // zh_CN
    }

    @Test
    public void createLocale() {
        // new Locale(String language, String country);
        Locale locale = new Locale("zh", "CN");
        System.out.println(locale);
        Locale locale2 = new Locale("zh", "GANGGUO");
        System.out.println(locale2); // zh_GANGGUO
    }
}
