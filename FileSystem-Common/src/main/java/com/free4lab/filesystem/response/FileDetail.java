package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by lizhenhao on 2017/6/8.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FileDetail {

    private Integer id;

    private String fileName;

    private String type;

    private String textFileName;

    private String textFilePath;

    private String picFileName;

    private String picFilePath;

    private Date updateTime;

    private String eventId;

    private String eventName;

    private String year;

    private String departmentId;

    private String departmentName;

    private String uri;

    private String enterpriseId;

    private String content;

    public FileDetail() {
    }

    public FileDetail(Integer id, String fileName, String type, String textFileName, String textFilePath, String picFileName, String picFilePath, Date updateTime, String eventId, String year, String departmentId, String uri, String enterpriseId, String content) {
        this.id = id;
        this.fileName = fileName;
        this.type = type;
        this.textFileName = textFileName;
        this.textFilePath = textFilePath;
        this.picFileName = picFileName;
        this.picFilePath = picFilePath;
        this.updateTime = updateTime;
        this.eventId = eventId;
        this.year = year;
        this.departmentId = departmentId;
        this.uri = uri;
        this.enterpriseId = enterpriseId;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    public String getTextFilePath() {
        return textFilePath;
    }

    public void setTextFilePath(String textFilePath) {
        this.textFilePath = textFilePath;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    public String getPicFilePath() {
        return picFilePath;
    }

    public void setPicFilePath(String picFilePath) {
        this.picFilePath = picFilePath;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
