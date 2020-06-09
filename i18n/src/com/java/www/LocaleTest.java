package com.java.www;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

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

    @Test
    public void resourceBundleTest() {
        // 获取不同的地区
        Locale cnLocale = Locale.CHINA;
        Locale usLocale = Locale.US;

        System.out.println(usLocale);  // en_US
        // 根据basename、Locale地区信息读取相应的资源配置文件
        // 多国语言的资源配置文件命名规则: basename_语言_国家.properties
        ResourceBundle rs1 = ResourceBundle.getBundle("i18n", cnLocale);
        System.out.println("email: " + rs1.getString("email"));
        System.out.println("password: " + rs1.getString("password"));
        System.out.println("");

        ResourceBundle rs2 = ResourceBundle.getBundle("i18n", usLocale);
        System.out.println("email: " + rs2.getString("email"));
        System.out.println("password: " + rs2.getString("password"));

        /*
en_US
email: 邮箱
password: 密码

email: email
password: password
         */
    }
}
