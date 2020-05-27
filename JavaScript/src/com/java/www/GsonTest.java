package com.java.www;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.bean.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * json字符串与java对象之间的互转
 * gson的使用
 */
public class GsonTest {
    // json字符串与java对象
    @Test
    public void beanAndJson() {
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


    }

    // java对象组成的List集合与json字符串的互转
    @Test
    public void listAndJson() {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i < 4; ++i) {
            personList.add(new Person(i, "王名" + i, 22));
        }

        Gson gson = new Gson();
        // 把List集合转换成json字符串
        String personListJsonStr = gson.toJson(personList);
        System.out.println("personListJsonStr:");
        System.out.println(personListJsonStr);

        // json字符串转换成List集合
        String personListJsonStr2 = "[{\"id\":1,\"name\":\"王子1\",\"age\":22},{\"id\":2,\"name\":\"王子2\",\"age\":23},{\"id\":3,\"name\":\"王子3\",\"age\":20}]";
        // 方法1
        List<Person> pList = gson.fromJson(personListJsonStr2, new PersonListType().getType());
        System.out.println("pList: ");
        System.out.println(pList);
        // 方法2
        List<Person> pList2 = gson.fromJson(personListJsonStr2, (new TypeToken<ArrayList<Person>>() {}).getType());
        System.out.println("pList2: ");
        System.out.println(pList2);
        System.out.println(pList2.get(0).getName());
    }

    // java对象组成的Map集合与json字符串的互转
    @Test
    public void mapAndJson() {
        Map<String, Person> map = new HashMap<>();
        map.put("p1", new Person(1001, "Harry", 12));
        map.put("p2", new Person(1002, "Lilly", 11));
        map.put("p3", new Person(1003, "Jenny", 12));
        Gson gson = new Gson();
        // map集合转换城json字符串
        String mapJsonStr = gson.toJson(map);
        System.out.println("mapJsonStr:");
        System.out.println(mapJsonStr);

        // json字符串转换成Map集合
        String mapJsonStr2 = "{\"p1\":{\"id\":2001,\"name\":\"Lucy\",\"age\":12},\"p2\":{\"id\":2002,\"name\":\"Jerry\",\"age\":11},\"p3\":{\"id\":2003,\"name\":\"Luobote\",\"age\":12}}";
        Map<String, Person> map2 = gson.fromJson(mapJsonStr2, (new TypeToken<HashMap<String, Person>>() {}).getType());
        System.out.println("map2:");
        System.out.println(map2);
        Person p = map2.get("p2");
        System.out.println("p2");
        System.out.println(p);
    }
}
