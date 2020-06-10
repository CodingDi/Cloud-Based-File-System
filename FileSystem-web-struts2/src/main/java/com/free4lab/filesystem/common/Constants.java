package com.free4lab.filesystem.common;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Di Wu on 2018/3/18.
 */
public class Constants {


    public static final String BASE_URI;
    public static final String NEW_FRONT_URL;
    public static final String SOUYA_APPKEY;
    public static final String SOUYA_SECRETKEY;
    public static String FILE_FIND = "FILE_FIND";
    public static String FILE_SEARCH = "FILE_SEARCH";

    public static final int GET = 1;
    public static final int PUT = 2;
    public static final int POST = 3;
    public static final int DELETE = 4;

    public static final String RELATIVE_PATH = "img/enterpriseImage/";

    public static class UPDATE_TYPE {
        public static final String RESET_PWD="RESET_PWD";
        public static final String CANCEL_ADMIN="CANCEL_ADMIN";
        public static final String SET_ADMIN="SET_ADMIN";
    }


    static {
        final Logger logger = Logger.getLogger(ConstantEnum.class);

        try {
            Properties p = new ConfigUtil().loadProperties("const.properties");

            BASE_URI = p.getProperty("BASE_URI");
            NEW_FRONT_URL = p.getProperty("NEW_FRONT_URL");
            SOUYA_APPKEY = p.getProperty("SOUYA_APPKEY");
            SOUYA_SECRETKEY = p.getProperty("SOUYA_SECRETKEY");

        } catch (IOException e) {
            logger.error("加载配置文件出错： "+e.getMessage());
            throw new RuntimeException("配置加载错误",e);
        }

        logger.info("！--------配置加载成功------------！");
    }
}
