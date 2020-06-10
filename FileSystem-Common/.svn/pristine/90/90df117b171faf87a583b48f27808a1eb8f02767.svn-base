package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Idan on 2017/7/26.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EnterpriseResponse{

    @XmlElementWrapper(name = "enterpriseList")
    @XmlElement(name = "enterprise")
    private List<EnterpriseDetail> enterpriseList;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public EnterpriseResponse() {
    }

    public EnterpriseResponse(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public EnterpriseResponse(List<EnterpriseDetail> enterpriseList,String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.enterpriseList = enterpriseList;
    }

    public List<EnterpriseDetail> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<EnterpriseDetail> enterpriseList) {
        this.enterpriseList = enterpriseList;
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
