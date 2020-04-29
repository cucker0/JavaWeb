package com.java.www;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * java URL编码、解码
 */
public class URLencoderAndURLdecoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "username=周星驰&password=zxc666";
        // URL编码
        String enUrl = URLEncoder.encode(url, "utf-8");
        System.out.println(enUrl);  // username%3D%E5%91%A8%E6%98%9F%E9%A9%B0%26password%3Dzxc666
        // URL解码
        String deUrl = URLDecoder.decode(url, "utf-8");
        System.out.println(deUrl);  // username=周星驰&password=zxc666
    }
}
