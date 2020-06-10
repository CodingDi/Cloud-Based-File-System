package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by lizhenhao on 2017/7/30.
 */
public class LogoResponse {

    @XmlElementWrapper(name = "LogoList")
    @XmlElement(name = "LogoDetail")
    private List<LogoDetail> logoList;
    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public LogoResponse() {
    }

    public LogoResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public LogoResponse(List<LogoDetail> logoList, String errorMessage, String errorCode) {
        this.logoList = logoList;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public List<LogoDetail> getLogoList() {
        return logoList;
    }

    public void setLogoList(List<LogoDetail> logoList) {
        this.logoList = logoList;
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
