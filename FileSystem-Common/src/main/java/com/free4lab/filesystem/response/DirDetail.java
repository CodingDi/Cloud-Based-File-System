package com.free4lab.filesystem.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lizhenhao on 2017/2/27.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DirDetail {
    /**
     * 每个节点的标识
     */
    private Integer id;

    /**
     * 父节点的标识
     */
    private Integer pId;

    private String name;

    private String type;

    private boolean isParent;

    private String enterpriseId;

    private String date;


    public DirDetail() {
    }

    public DirDetail(String type, boolean isParent) {
        this.type = type;
        this.isParent = isParent;
    }

    public DirDetail(String name, String type, String userId) {
        this.name = name;
        this.type = type;
        this.enterpriseId = userId;
    }

    public DirDetail(Integer id, Integer pId, String name, String type, boolean isParent, String userId) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.type = type;
        this.isParent = isParent;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
