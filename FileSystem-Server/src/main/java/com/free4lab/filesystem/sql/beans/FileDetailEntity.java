package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by lizhenhao on 2017/6/8.
 */

@Entity
@Table(name="file_detail")
public class FileDetailEntity{

    private Integer id;

    private String fileName;

    private String type;

    private String textFileName;

    private String textFilePath;

    private String picFileName;

    private String picFilePath;

    private Date updateTime;

    private String eventId;

    private String year;

    private String departmentId;

    private String uri;

    private String enterpriseId;

    private String content;

    private String souyaStatus;

    private String tikaStatus;

    private Date createDate;

    //非映射列
    private InputStream file;

    @Column(name = "create_time")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public FileDetailEntity() {
    }

    public FileDetailEntity(Integer id, String fileName, String type, String textFileName, String textFilePath, String picFileName, String picFilePath, Date updateTime, String eventId, String year, String departmentId, String uri, String enterpriseId, String content, String souyaStatus, String tikaStatus, Date createDate) {
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
        this.souyaStatus = souyaStatus;
        this.tikaStatus = tikaStatus;
        this.createDate = createDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "filename",nullable = true)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "type",nullable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Column(name = "textfilename")
    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    @Column(name = "textfilepath")
    public String getTextFilePath() {
        return textFilePath;
    }

    public void setTextFilePath(String textFilePath) {
        this.textFilePath = textFilePath;
    }

    @Column(name = "picfilename")
    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    @Column(name = "picfilepath")
    public String getPicFilePath() {
        return picFilePath;
    }

    public void setPicFilePath(String picFilePath) {
        this.picFilePath = picFilePath;
    }

    @Column(name = "updatetime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "eventid")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "departmentid")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "enterpriseid")
    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Column(name = "souya_status")
    public String getSouyaStatus() {
        return souyaStatus;
    }

    public void setSouyaStatus(String souyaStatus) {
        this.souyaStatus = souyaStatus;
    }

    @Column(name = "tika_status")
    public String getTikaStatus() {
        return tikaStatus;
    }

    public void setTikaStatus(String tikaStatus) {
        this.tikaStatus = tikaStatus;
    }

    @Transient
    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }
}
