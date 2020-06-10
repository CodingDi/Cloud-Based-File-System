package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.EnterpriseClient;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.EnterpriseDetail;
import com.free4lab.filesystem.response.EnterpriseResponse;
import com.free4lab.filesystem.util.ClientFactory;

import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Created by Idan on 2017/7/26.
 */
public class EnterpriseAction extends BaseAction {
    private EnterpriseClient enterpriseClient = ClientFactory.getEnterpriceClient();
    private String enterpriseId;
    private String name;
    private String description;
    private List<EnterpriseDetail> enterpriseList;

    //返回消息
    private String code;
    private String message;

    public String findAll() {
        EnterpriseResponse enterpriseResponse = enterpriseClient.Find().execute();
        code = enterpriseResponse.getErrorCode();
        if (code.equals(Signal.OK)) {
            enterpriseList = enterpriseResponse.getEnterpriseList();
        }
        message = enterpriseResponse.getErrorMessage();
        return SUCCESS;
    }

    public String update() {
        if (enterpriseId ==null) {
            code = Signal.STATUS_INVALID_PARAMETER;
            message = Signal.UPDATE_ENTERPRISE_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = enterpriseClient.Update().params("enterpriseId",enterpriseId).
                params("name",name).params("description",description).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        if (name != null && !name.equals("")) {
            getSession().put("enterpriseName", name);
        }
        return SUCCESS;
    }

    public String deleteById() {
        if (enterpriseId==null) {
            code=Signal.STATUS_INVALID_PARAMETER;
            message = Signal.DELETE_ENTERPRISE_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = enterpriseClient.Delete().params("enterpriseId",enterpriseId).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    public String add() {
        Form form = new Form();
        form.param("name",name);
        form.param("description",description);
        BasicResponse basicResponse = enterpriseClient.Save(form).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EnterpriseDetail> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<EnterpriseDetail> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
