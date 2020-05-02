package com.bj.utils;

import java.security.MessageDigest;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 18:02
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class MD5Util {
    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16){
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    /**
     * 加密
     * @param value
     * @return
     */
    public static String encryptByMD5(String value){
        return convertMD5(value);
    }

    /**
     * 解密
     * @param value
     * @return
     */
    public static String dencryptByMD5(String value){
        return convertMD5(value);
    }

    // 测试主函数
    public static void main(String args[]) {
        String s = "bj1234567";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        String enVale = convertMD5(s);
        System.out.println("加密的：" + enVale);
        System.out.println("解密的：" + convertMD5(enVale));
    }
}
