package com.free4lab.filesystem.util;/**
 * Created by dell on 2016/6/5.
 */


import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字符串工具类
 *
 * @since 1.0.0
 */
public final class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final  String SEPARATOR = String.valueOf((char)29);

    public static boolean isNullOrEmpty(String str){
        return str==null||str.length()==0;
    }
    public static String[] splitString(String str,String regx){
        return str.split(regx);
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str!=null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 流转流
     */
    public static InputStream streamRefresh(InputStream in) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = in.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        return new ByteArrayInputStream(outStream.toByteArray());
    }
}
