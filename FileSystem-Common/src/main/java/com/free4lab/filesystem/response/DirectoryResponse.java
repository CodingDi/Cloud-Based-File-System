package com.free4lab.filesystem.response;

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
public class DirectoryResponse {

    /**
     * 所包含文件的列表
     */
    @XmlElementWrapper(name = "fileList")
    @XmlElement(name = "basicFile")
    private List<DirDetail> dirList;


    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public DirectoryResponse() {
    }

    public DirectoryResponse(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public DirectoryResponse(List<DirDetail> dirList, String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.dirList = dirList;
    }

    public List<DirDetail> getDirList() {
        return dirList;
    }

    public void setDirList(List<DirDetail> dirList) {
        this.dirList = dirList;
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
