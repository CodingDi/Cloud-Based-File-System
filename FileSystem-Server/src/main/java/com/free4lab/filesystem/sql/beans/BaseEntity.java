package com.free4lab.filesystem.sql.beans;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Idan on 2017/7/20.
 */
public class BaseEntity implements Serializable{

    private Date createDate;

    @Column(name = "create_time")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
