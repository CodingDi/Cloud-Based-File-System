package com.free4lab.filesystem.common;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lizhenhao on 2017/2/15.
 */
public class Constants {

    //数据库查询属性常量名称
    public static final String FILENAME = "fileName";
    public static final String ENTERPRISEID = "enterpriseId";
    public static final String EVENTID = "eventId";
    public static final String TIME = "year";
    public static final String DEPARTMENTID = "departmentId";
    public static final String TYPE = "type";
    public static final String TELEPHONE = "telephone";
    public static final String PASSWORD = "password";


    public static final String TEXT = "text";
    public static final String PIC = "pic";
    public static final String ALL = "all";

    public static final String PU_NAME = "VMC_PU";

    public static final String ROOT_DIR;

    public static final String DIR_TYPE;

    public static final String FILE_TYPE;

    public static final String FILE_PATH;

    public static final String SOUYA_APPKEY;

    public static final String SOUYA_SECRETKEY;

    static {
         final Logger logger = Logger.getLogger(ConstantEnum.class);

        try {
            Properties p = new ConfigUtil().loadProperties("file.properties");

            ROOT_DIR = p.getProperty("ROOT_DIR","/home/fileSystem");
            DIR_TYPE = p.getProperty("DIR_TYPE","d");
            FILE_TYPE = p.getProperty("DIR_TYPE","-");
            FILE_PATH = p.getProperty("FILE_PATH","files");
            SOUYA_APPKEY = p.getProperty("SOUYA_APPKEY");
            SOUYA_SECRETKEY = p.getProperty("SOUYA_SECRETKEY");

        } catch (IOException e) {
            logger.error("加载配置文件出错： "+e.getMessage());
            throw new RuntimeException("配置加载错误",e);
        }

        logger.info("！--------配置加载成功------------！");
    }
}
