package com.fdzc.javaeeserver.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    /**
     * 将字符串进行MD5加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuilder sb = new StringBuilder();
            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串进行MD5解密
     *
     * @param str 要解密的字符串
     * @return 解密后的字符串
     */
    public static String decode(String str) {
        // MD5是不可逆的，无法进行解密
        return null;
    }
}

