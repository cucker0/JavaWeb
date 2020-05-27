package com.java.www;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.java.bean.Group;
import com.java.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonTest {

    // javaBean对象转json字符串
    @Test
    public void bean2Json() {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User user1 = new User(2L, "王维");
        User user2 = new User(3L, "贺知章");
        group.addUser(user1);
        group.addUser(user2);

        String groupJsonStr = JSON.toJSONString(group);
        System.out.println(groupJsonStr);  // {"id":0,"name":"admin","users":[{"id":2,"name":"王维"},{"id":3,"name":"贺知章"}]}
    }

    // json字符串转java Bean对象
    @Test
    public void json2Beans() {
        String jsonStr = "{\"id\":11,\"name\":\"alibaba\",\"users\":[{\"id\":2,\"name\":\"李白\"},{\"id\":3,\"name\":\"王伦\"}]}";
        Group group = JSON.parseObject(jsonStr, Group.class);
        System.out.println(group);
    }

    // List与json互转
    @Test
    public void listAndJson() {
        List<User> stringList = new ArrayList<>();
        stringList.add(new User(1L, "lanlan"));
        stringList.add(new User(2L, "bobo"));
        stringList.add(new User(3L, "dudu"));
        // List 转json
        String jsonStr = JSON.toJSONString(stringList);
        System.out.println("jsonStr");
        System.out.println(jsonStr);  // [{"id":1,"name":"lanlan"},{"id":2,"name":"bobo"},{"id":3,"name":"dudu"}]

        // json转List
        List<User> userList = JSON.parseArray(jsonStr, User.class);
        // List<User> userList = JSON.parseObject(jsonStr,new TypeReference<List<User>>() {});  // 这种方法也可以
        System.out.println("userList: ");
        System.out.println(userList);  // [User{id=1, name='lanlan'}, User{id=2, name='bobo'}, User{id=3, name='dudu'}]
        System.out.println(userList.get(0).getName());
    }

    // Map与json互转
    @Test
    public void mapAndJson() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("u1", new User(11L, "丁丁"));
        userMap.put("u2", new User(12L, "啦啦"));
        userMap.put("u3", new User(13L, "迪斯"));
        // map转json
        String userMapJsonStr = JSON.toJSONString(userMap);
        System.out.println("userMapJsonStr:");
        System.out.println(userMapJsonStr); // {"u1":{"id":11,"name":"丁丁"},"u2":{"id":12,"name":"啦啦"},"u3":{"id":13,"name":"迪斯"}}

        // json转map
        // Map<String, User> userMap2 = JSON.parseObject(userMapJsonStr, new TypeReference<Map<String, User>>() {});
        Map<String, User> userMap2 = JSON.parseObject(userMapJsonStr, new TypeReference<>() {}); // 与上面一样，是<>钻石简略写法
        System.out.println("userMap2: ");
        System.out.println(userMap2);  // {u1=User{id=11, name='丁丁'}, u2=User{id=12, name='啦啦'}, u3=User{id=13, name='迪斯'}}
        System.out.println(userMap2.get("u1").getName());
    }
}
