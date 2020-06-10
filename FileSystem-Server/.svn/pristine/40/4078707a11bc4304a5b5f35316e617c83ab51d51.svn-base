package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lizhenhao on 2017/2/27.
 */
@Entity
@Table(name="directory_detail")
public class DirDetailEntity{
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

    private Date createDate;

    @Column(name = "create_time")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public DirDetailEntity() {
    }

    public DirDetailEntity(String name, String type, String userId) {
        this.name = name;
        this.type = type;
        this.enterpriseId = userId;
    }

    public DirDetailEntity(Integer id, Integer pId, String name, String type, boolean isParent, String userId) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.type = type;
        this.isParent = isParent;
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

    @Transient
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type",nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Transient
    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    @Column(name = "enterpriseid")
    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
