package com.java.www;

import com.google.gson.Gson;
import com.java.bean.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * json字符串与java对象之间的互转
 * gson的使用
 *
 */
public class GsonTest {
    public static void main(String[] args) {
        // 先创建一个gson对象
        Gson gson = new Gson();
        Person person = new Person(1001, "刘轩瑞", 36);

        // java对象转json字符串
        String personJsonStr = gson.toJson(person);
        System.out.println("personJsonStr: " + personJsonStr);  // {"id":1001,"name":"刘轩瑞","age":36}

        // json字符串转java对象
        String personJsonStr2 = "{\"id\":1002,\"name\":\"赵匡胤\",\"age\":28}";
        Person person2 = gson.fromJson(personJsonStr2, Person.class);
        System.out.println(person2);

        // java对象List集合与json字符串的互转
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i < 4; ++i) {
            personList.add(new Person(i, "王-" + i, 22));
        }

    }
}
