package com.java.web;

import com.google.gson.Gson;
import com.java.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class AjaxServlet extends BaseServlet {
    protected void jsAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("js原生的ajax请求");
        Random random = new Random(System.currentTimeMillis());
        // Person p = new Person(1001, "楚中天", 23);
        Person p = new Person(random.nextInt(100), "楚中天", 23);
        Gson gson = new Gson();
        String pJsonStr = gson.toJson(p);
        response.getWriter().write(pJsonStr);
    }

}
