package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/7/18.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponse {

    @XmlElementWrapper(name = "UserList")
    @XmlElement(name = "UserDetail")
    private List<UserDetail> userLists;
    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误码
     */
    private String errorCode;

    public UserResponse() {
    }

    public UserResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public UserResponse(List<UserDetail> userLists, String errorMessage, String errorCode) {
        this.userLists = userLists;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public List<UserDetail> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<UserDetail> userLists) {
        this.userLists = userLists;
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
