package com.free4lab.filesystem.util;

import com.free4lab.filesystem.common.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by lizhenhao on 2017/6/8.
 */
public class NfsLocationUtil {

    private static BigInteger CHAR_NUM = BigInteger.valueOf(26);
    private static MessageDigest md5 = null;
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
    /**
     * 0x0F
     */
    public static int MASK = 15;
    /**
     * 用于获取一个String的md5数值
     */
    private static BigInteger getMd5Num(String str) {
        byte[] bs = md5.digest(str.getBytes());
        BigInteger num = BigInteger.ZERO;
        for (int i = 0; i < bs.length; i++) {
            int x = bs[i];
            if (x < 0) {
                x += 256;
            }
            num = num.shiftLeft(4);
            num = num.add(BigInteger.valueOf(x & MASK));
        }
        return num;
    }


    public static String getNfsLocation(String fileName) {
        BigInteger md5Num = getMd5Num(fileName.trim());

        // md5 % 26
        int firstCharVal = md5Num.remainder(CHAR_NUM).intValue();
        // (md5 / 26 ) % 26
        int secondCharVal = md5Num.divide(CHAR_NUM).remainder(CHAR_NUM).intValue();

        char aChar = 'a';
        int aCharVal = (int) aChar;

        char firstChar = (char) (aCharVal + firstCharVal);
        char secondChar = (char) (aCharVal + secondCharVal);

        String fileSeparator = "/";
        return Constants.ROOT_DIR + Constants.FILE_PATH + fileSeparator
                + firstChar + fileSeparator
                + secondChar + fileSeparator;
    }

}
