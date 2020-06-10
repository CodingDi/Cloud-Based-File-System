package com.free4lab.filesystem.exception;

/**
 * Created by lizhenhao on 2017/6/6.
 */
public class FileSystemResponseException extends Exception {

    private Integer errorCode;

    private String errorMessage;

    public FileSystemResponseException() {
        super();
    }

    public FileSystemResponseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public FileSystemResponseException(String errorMessage,Integer errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
