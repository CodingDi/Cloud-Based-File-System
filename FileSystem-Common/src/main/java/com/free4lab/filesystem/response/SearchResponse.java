package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/7/4.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResponse {

    /**
     * 所包含文件的列表
     */
    @XmlElementWrapper(name = "searchList")
    @XmlElement(name = "SearchDetail")
    private List<SearchDetail> searchList;
    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    private String operation;

    public SearchResponse() {
    }

    public SearchResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public SearchResponse(String errorMessage, String errorCode, String operation) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.operation = operation;
    }

    public SearchResponse(List<SearchDetail> searchList, String errorMessage, String errorCode, String operation) {
        this.searchList = searchList;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.operation = operation;
    }

    public List<SearchDetail> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<SearchDetail> searchList) {
        this.searchList = searchList;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
