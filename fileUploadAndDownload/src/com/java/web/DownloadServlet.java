package com.java.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * 下载文件
 */
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("url");
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        System.out.println("fileName: " + fileName);
        if (path == null) {
            response.getWriter().write("此文件不存在");
            return;
        }
        // 读取文件
        InputStream is = getServletContext().getResourceAsStream(path);
        // 获取输出流
        ServletOutputStream os = response.getOutputStream();
        // 获取文件类型
        String mimeType = getServletContext().getMimeType(path);
        System.out.println("mimeType: " + mimeType);
        // 设置response的响应头字段 Content-Type: 文件类型
        response.setContentType(mimeType);
        // 告诉浏览器使用附件形式解析(图片就不会直接展示了)，文件名，并把文件名进行URL编码，避免乱码
        String attachment = attachment = "attachment; filename=" + URLEncoder.encode(fileName, "utf-8");
        response.setHeader("Content-Disposition", attachment);
        // 从输入流读取数据，复制到输出流
        IOUtils.copy(is, os);
        os.close();
        is.close();
    }
}
