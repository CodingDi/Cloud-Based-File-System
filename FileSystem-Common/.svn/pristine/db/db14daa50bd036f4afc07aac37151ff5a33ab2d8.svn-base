package com.free4lab.filesystem.common;


import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by lizhenhao on 2017/2/16.
 */
public class ConfigUtil {

    public ConfigUtil() {
    }

    public Properties loadProperties(String filePath) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(filePath);
        Properties p = new Properties();
        p.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
        return p;
    }
}
