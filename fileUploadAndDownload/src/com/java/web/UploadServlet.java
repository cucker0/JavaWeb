package com.java.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 可上传文件的servlet
 */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // // 获取request body中的数据
        // ServletInputStream inputStream = request.getInputStream();
        // byte[] bytes = inputStream.readAllBytes();
        // System.out.println(new String(bytes));


        // 1. Check that we have a file upload request，
        // 实现方法：判断request请求头的Content-Type字段值是否以“multipart/”开头
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        // 2. Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 3. Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            // 4. Parse the request
            List<FileItem> items = upload.parseRequest(request);
            System.out.println("表单项个数：" + items.size());
            // 5. 遍历表单项
            for (FileItem fileItem : items) {
                // 普通的表单项
                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    String fileItemValue = fileItem.getString("utf-8");
                    System.out.println("表单项名：" + fieldName + ", 表单项值：" + fileItemValue);
                }
                // 文件
                else {
                    String fieldName = fileItem.getFieldName();
                    System.out.println("fieldName: " + fieldName);
                    // IE浏览器的为绝对路径，如 D:\wiki\ac41b1a90430164fc0039736c29933b8.jpg
                    // chrome浏览器的为文件名：如 ac41b1a90430164fc0039736c29933b8.jpg
                    String fileName = fileItem.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    // 保存文件的路径
                    String filePaht = getServletContext().getRealPath("/upload/") +  uuid + suffix;
                    File f = new File(filePaht);
                    System.out.println("file path: " + f);
                    // 把文件写入到指定的路径
                    fileItem.write(f);
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
