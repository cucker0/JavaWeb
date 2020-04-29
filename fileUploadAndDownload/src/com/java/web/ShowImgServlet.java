package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowImgServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("files", getFileList());
        request.getRequestDispatcher("/showImg.jsp").forward(request, response);
    }

    // 获取图片列表
    private List<String> getFileList() {
        List<String> files = new ArrayList<>();
        String dirPath = getServletContext().getRealPath("/upload/");
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return files;
        }
        String[] filesStr = dir.list();
        for (String f: filesStr) {
            files.add("upload/" + f);
        }
        return files;
    }
}
