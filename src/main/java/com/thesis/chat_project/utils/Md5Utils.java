package com.thesis.chat_project.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

/**
 *@description:   MD5加密
 *@author:        zhushubiao
 *@email:         617374631@qq.com
 *@date:          2020/2/19
 *@time:          15:23
 */
public class Md5Utils {

    private static final String ALGORITHM = "MD5";

    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance(ALGORITHM);
            algorithm.reset();
            algorithm.update(s.getBytes(StandardCharsets.UTF_8));
            return algorithm.digest();
        } catch (Exception ignored) {
        }
        return null;
    }

    private static final String toHex(byte[] hash) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;
        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s) {
        try {
            String toHexed = toHex(md5(s));
                if(null != toHexed){
                    return new String(toHexed.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                }else {
                    return s;
                }
        } catch (Exception e) {
            return s;
        }
    }
}
