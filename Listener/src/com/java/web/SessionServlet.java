package com.java.web;

import com.alibaba.fastjson.JSON;
import com.java.listener.cycle.HttpSessionCycleListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.java.listener.cycle.HttpSessionCycleListener.getSessions;

public class SessionServlet extends BaseServlet {
    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("session_id", session.getId());
        System.out.println("createSession:");
        System.out.println(map);
        response.getWriter().write(JSON.toJSONString(map));
    }

    protected void listSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("total", getSessions().size());
        map.put("sessions", getSessions());
        System.out.println(map);
        response.getWriter().write(JSON.toJSONString(map));
    }

    protected void deleteSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 让session立即失效
        session.invalidate();
    }
}
