package com.free4lab.filesystem.beans;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/2/15.
 */

/**
 * 目录结构类
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DirConstruct {

    /**
     * 所包含文件的列表
     */
    @XmlElementWrapper(name = "fileList")
    @XmlElement(name = "basicFile")
    private List<BasicFile> fileList;


    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public DirConstruct() {
    }

    public DirConstruct(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public DirConstruct(List<BasicFile> fileList,String errorMessage,String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.fileList = fileList;
    }

    public List<BasicFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BasicFile> fileList) {
        this.fileList = fileList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
