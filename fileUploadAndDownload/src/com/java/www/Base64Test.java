package com.java.www;

import com.mchange.util.Base64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /* Base64编码 */
        String str = "暗送秋波";
        // 获取Base64编码器
        Base64.Encoder encoder = Base64.getEncoder();
        // 编码操作
        byte[] enStr = encoder.encode(str.getBytes("utf-8"));
        System.out.println(new String(enStr));  // 5pqX6YCB56eL5rOi

        /* Base64解码 */
        String enStr2 = "5pqX6YCB56eL5rOi";
        // 获取解Base64码器
        Base64.Decoder decoder = Base64.getDecoder();
        // 解码操作
        byte[] decode = decoder.decode(enStr2);
        System.out.println(new String(decode));  // 暗送秋波
    }
}
