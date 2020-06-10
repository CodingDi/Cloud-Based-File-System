package com.free4lab.filesystem.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 无返回数据型操作返回类
 * Created by lizhenhao on 2017/2/16.
 */

@XmlRootElement
public class BasicConstruct {

    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 错误码
     */
    private String errorCode;

    public BasicConstruct(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public BasicConstruct() {
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
