package com.free4lab.filesystem.beans;

/**
 * Created by lizhenhao on 2017/2/15.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 基本文件类
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BasicFile {

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件类型
     */
    private String type;


    public BasicFile(String fileName, String path,String type) {
        this.fileName = fileName;
        this.path = path;
        this.type = type;
    }

    public BasicFile() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
