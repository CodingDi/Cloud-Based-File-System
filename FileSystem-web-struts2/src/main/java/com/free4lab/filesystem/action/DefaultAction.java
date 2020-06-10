package com.free4lab.filesystem.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lizhenhao on 2017/7/30.
 */
public class DefaultAction extends ActionSupport {

    private String enterpriseId;

    public String execute() {
        return SUCCESS;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
