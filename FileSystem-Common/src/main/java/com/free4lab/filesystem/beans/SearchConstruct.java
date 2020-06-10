package com.free4lab.filesystem.beans;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/2/17.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchConstruct {

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

    public SearchConstruct() {
    }

    public SearchConstruct(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public SearchConstruct(List<BasicFile> fileList,String errorMessage, String errorCode) {
        this.fileList = fileList;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
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

    public List<BasicFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BasicFile> fileList) {
        this.fileList = fileList;
    }
}
