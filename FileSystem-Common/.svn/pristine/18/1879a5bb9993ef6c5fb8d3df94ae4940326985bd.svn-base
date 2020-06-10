package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/6/8.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FileResponse {

    /**
     * 所包含文件的列表
     */
    @XmlElementWrapper(name = "fileList")
    @XmlElement(name = "fileDetail")
    private List<FileDetail> fileList;
    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public FileResponse() {
    }


    public FileResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public FileResponse(List<FileDetail> fileList, String errorMessage, String errorCode) {
        this.fileList = fileList;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public List<FileDetail> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileDetail> fileList) {
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
