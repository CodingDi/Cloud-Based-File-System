package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Idan on 2017/7/26.
 */
@Entity
@Table(name="enterprise")
public class EnterpriseEntity {

    private Integer id;
    private String name;
    private String description;
    private Date createDate;

    public EnterpriseEntity() {
    }

    public EnterpriseEntity(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
