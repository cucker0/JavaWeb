package com.java.webserver;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

/**
 * TCP Socket 模拟浏览器
 */
public class WebClient {
    public static void main(String[] args) {
//        String host = "www.baidu.com";
//        String shortUrl = "/";
//        int port = 80;

        String host = "127.0.0.1";
        String shortUrl = "/tomcat/";
        int port = 8080;

        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);

        try {
            System.out.println();

            socket.connect(inetSocketAddress, 1000);

            String request = "GET "+ shortUrl + " HTTP/1.1\r\n" +
                    "Host: " + InetAddress.getByName(host).getHostAddress() + ":" + port + "\r\n";
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(request);

            String tem;
            // 这里要注意二进制字节流转换为字符流编码要使用UTF-8
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            // 这里会被阻塞，所以需要根据header中的Content-Length类判断是否接受完毕
            int len = 0;
            int contentLength = -1;
            System.out.println("----------------");
            while ((tem = bufferedReader.readLine()) != null) {
                len += tem.length();
                if (tem.startsWith("Content-Length")) {
                    contentLength = Integer.valueOf(tem.substring(16));
//                    System.out.println(contentLength);
                }
                if (contentLength > 0 && len >= contentLength) {
                    break;
                }
                System.out.println(tem);
            }
            System.out.println("----------------");
            System.out.println("len: " + len);

            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
