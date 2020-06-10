package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Idan on 2017/7/26.
 */
@Entity
@Table(name="enterprise_logo")
public class LogoEntity {

    private Integer id;
    private String name;
    private String type;
    private String relativePath;
    private String absolutePath;
    private String relativePathServer;
    private String absolutePathServer;
    private String enterpriseId;
    private Date createDate;

    public LogoEntity() {
    }

    public LogoEntity(Integer id, String name, String type, String relativePath, String absolutePath, String relativePathServer, String absolutePathServer, String enterpriseId, Date createDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.relativePath = relativePath;
        this.absolutePath = absolutePath;
        this.relativePathServer = relativePathServer;
        this.absolutePathServer = absolutePathServer;
        this.enterpriseId = enterpriseId;
        this.createDate = createDate;
    }

    @Column(name = "create_time")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "relativepath")
    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    @Column(name = "absolutepath")
    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    @Column(name = "relativepath_server")
    public String getRelativePathServer() {
        return relativePathServer;
    }

    public void setRelativePathServer(String relativePathServer) {
        this.relativePathServer = relativePathServer;
    }

    @Column(name = "absolutepath_server")
    public String getAbsolutePathServer() {
        return absolutePathServer;
    }

    public void setAbsolutePathServer(String absolutePathServer) {
        this.absolutePathServer = absolutePathServer;
    }

    @Column(name = "enterpriseid")
    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
