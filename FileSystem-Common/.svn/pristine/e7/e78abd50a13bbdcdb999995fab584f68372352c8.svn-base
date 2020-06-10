package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;

/**
 *
 * Created by lizhenhao on 2017/2/20.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DownFileResponse {

    private InputStream inputStream;

    private String contentType;

    private long contentLength;

    private String contentDisposition;

    private String errorMessage;

    private String errorCode;

    public DownFileResponse() {
    }

    public DownFileResponse(InputStream inputStream, String contentType, long contentLength, String contentDisposition, String errorMessage, String errorCode) {
        this.inputStream = inputStream;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.contentDisposition = contentDisposition;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public DownFileResponse(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }
}
