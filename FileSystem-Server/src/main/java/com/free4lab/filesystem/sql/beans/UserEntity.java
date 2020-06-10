package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lizhenhao on 2017/7/18.
 */

@Entity
@Table(name="user")
public class UserEntity{

    private Integer id;

    private String userName;

    private String role;

    private String enterpriseId;

    private String telephone;

    private String password;

    private Date createDate;

    private EnterpriseEntity enterpriseEntity;

    @Column(name = "create_time")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserEntity() {
    }

    public UserEntity(Integer id, String userName, String role, String enterpriseId) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.enterpriseId = enterpriseId;
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

    @Column(name = "username",nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "role",nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "enterpriseid",nullable = false)
    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Column(name = "telephone",nullable = false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name = "enterpriseid",referencedColumnName = "id",insertable = false,updatable = false)
    public EnterpriseEntity getEnterpriseEntity() {
        return enterpriseEntity;
    }

    public void setEnterpriseEntity(EnterpriseEntity enterpriseEntity) {
        this.enterpriseEntity = enterpriseEntity;
    }
}
