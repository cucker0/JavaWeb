package com.java.web;

import com.google.gson.Gson;
import com.java.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AjaxServlet extends BaseServlet {
    private Gson gson = new Gson();

    protected void jsAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("js原生的ajax请求");
        Random random = new Random(System.currentTimeMillis());
        // Person p = new Person(1001, "楚中天", 23);
        Person p = new Person(random.nextInt(100), "楚中天", 23);
        String pJsonStr = gson.toJson(p);
        response.getWriter().write(pJsonStr);
    }

    protected void jqAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person(101, "张悬", 18);
        System.out.println("$.ajax请求");
        String data = gson.toJson(p);
        response.getWriter().write(data);
    }

    protected void jqGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person(102, "郑定", 20);
        System.out.println("$.get请求");
        String data = gson.toJson(p);
        response.getWriter().write(data);
    }

    protected void jqPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person(103, "赵聂", 22);
        System.out.println("$.post请求");
        String data = gson.toJson(p);
        response.getWriter().write(data);
    }

    protected void jqGetJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person(104, "罗素", 24);
        System.out.println("$.post请求");
        String data = gson.toJson(p);
        response.getWriter().write(data);
    }

    protected void jqSerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试jq的serialize方法");
        String[] citys = request.getParameterValues("citys");
        String sex = request.getParameter("sex");
        System.out.println("citys: ");
        for (String city : citys) {
            System.out.println(city);
        }
        System.out.println("sex: " + sex);
        Map<Object, Object> map = new HashMap<>();
        map.put("class", 3);
        map.put("name", "Lilly");
        map.put("age", 13);
        response.getWriter().write(gson.toJson(map));
    }
}
