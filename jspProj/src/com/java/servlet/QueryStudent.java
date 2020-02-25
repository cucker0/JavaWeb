package com.java.servlet;

import com.java.jsp.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保存学生信息的list
        List<Student> students = new ArrayList<>();

        // 生成20个学生信息并保存到students中
        for (int i = 1; i <= 20; ++i) {
            if (i < 10) {
                students.add(new Student(i, "stu_" + i, "137 4000 150" + i));
            } else {
                students.add(new Student(i, "stu_" + i, "137 4000 15" + i));
            }
        }

        // 把students数据保存到域对象中
        request.setAttribute("stus", students);

        // 转发请求
        request.getRequestDispatcher("/exercise/table_student_info.jsp").forward(request, response);
    }
}
