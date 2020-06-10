package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.LogoClient;
import com.free4lab.filesystem.client.UserClient;
import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.*;
import com.free4lab.filesystem.util.ClientFactory;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Form;
import java.util.List;

public class AccountAction extends BaseAction {

    private UserClient userClient = ClientFactory.getUserClient();
    private LogoClient logoClient = ClientFactory.getLogoClient();
    protected Logger logger = Logger.getLogger(AccountAction.class);

    private String tel;
    private String psw;
    private String oldPSW;
    private String newPSW;
    private String name;
    private String redirectUrl;
    private String enterpriseId;
    private String role;
    private String code;
    private String message;
    private String userId;
    private String updateType;
    private List<UserDetail> users;

    private String bannerLogoPath;
    private String innerLogoPath;
    private String landingLogoPath;



    public String landing() {
        return SUCCESS;
    }

    //登录
    public String login() {
        UserResponse userResponse = userClient.Login().params("telephone",tel).params("password",psw).execute();
        if(userResponse.getErrorCode().equals(Signal.OK)) {
            if(userResponse.getUserLists().size() != 0) {
                UserDetail userDetail = userResponse.getUserLists().get(0);
                role = userDetail.getRole();
                ActionContext.getContext().getSession().put("name", userDetail.getUserName());
                ActionContext.getContext().getSession().put("userId", userDetail.getId());
                ActionContext.getContext().getSession().put("enterpriseId", userDetail.getEnterpriseId());
                ActionContext.getContext().getSession().put("enterpriseName", userDetail.getEnterpriseName());
                logger.info("userDetail.getEnterpriseName()"+userDetail.getEnterpriseName());
                ActionContext.getContext().getSession().put("role", role);
                if (role.equals(ConstantEnum.USER_ROLE.ROLE_ROOT)) {
                    redirectUrl = "/home/enterprise/enterprise-admin.jsp?menu=root";
                } else {
                    redirectUrl = "/home/index.jsp?menu=home";
                }
                return SUCCESS;
            }
            else {
                return LOGIN;
            }
        }
        else {
            return LOGIN;
        }
    }

    //注销
    public String logout() {
        ActionContext.getContext().getSession().remove("userId");
        ActionContext.getContext().getSession().remove("enterpriseId");
        ActionContext.getContext().getSession().remove("name");
        ActionContext.getContext().getSession().remove("role");
        return SUCCESS;
    }


    //获得企业中不同角色的用户
    public String getAllUserByRoleAndEnterpriseId() {
        String enterpriseId = this.findEnterpriseId();
        UserResponse userResponse = userClient.Find().params("enterpriseId",enterpriseId).params("role",role).execute();
        code = userResponse.getErrorCode();
        if (code.equals(Signal.OK)) {
            users = userResponse.getUserLists();
        } else {
            message = userResponse.getErrorMessage();
        }
        return SUCCESS;
    }

    // 根据角色获得用户
    public String getAllUserByRole() {
        UserResponse userResponse = userClient.FindByRole().params("role",role).execute();
        code = userResponse.getErrorCode();
        if (code.equals(Signal.OK)) {
            users = userResponse.getUserLists();
        } else {
            message = userResponse.getErrorMessage();
        }
        return SUCCESS;
    }

    //添加用户
    public String addUser() {
        if (role == null) {
            role = ConstantEnum.USER_ROLE.ROLE_USER;
        }
        String reqEnterpriseId;
        if (findRole().equals(ConstantEnum.USER_ROLE.ROLE_ROOT)) {
            reqEnterpriseId = enterpriseId;
            role = ConstantEnum.USER_ROLE.ROLE_ADMIN;
        } else {
            reqEnterpriseId = this.findEnterpriseId();
        }
        Form form = new Form();
        form.param("userName",name);
        form.param("role",role);
        form.param("enterpriseId",reqEnterpriseId);
        form.param("telephone",tel);
        form.param("password",psw);
        BasicResponse basicResponse = userClient.Save(form).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    //删除用户
    public String deleteById() {
        if (userId==null) {
            code=Signal.STATUS_INVALID_PARAMETER;
            message = Signal.DELETE_USER_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = userClient.Delete().params("userId",userId).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    //修改用户信息
    public String updateUser() {
        if (userId==null) {
            code=Signal.STATUS_INVALID_PARAMETER;
            message = Signal.UPDATE_USER_ERROR;
            return SUCCESS;
        }
//        switch (updateType) {
//            case Constants.UPDATE_TYPE.RESET_PWD:
//                psw = "abc123";
//                break;
//            case Constants.UPDATE_TYPE.CANCEL_ADMIN:
//                role = ConstantEnum.USER_ROLE.ROLE_USER;
//                break;
//            case Constants.UPDATE_TYPE.SET_ADMIN:
//                role = ConstantEnum.USER_ROLE.ROLE_ADMIN;
//                break;
//        }
        if(updateType.equals(Constants.UPDATE_TYPE.RESET_PWD)) {
            psw = "abc123";
        }
        else if(updateType.equals(Constants.UPDATE_TYPE.CANCEL_ADMIN)) {
            role = ConstantEnum.USER_ROLE.ROLE_USER;
        }
        else if(updateType.equals(Constants.UPDATE_TYPE.SET_ADMIN)){
            role = ConstantEnum.USER_ROLE.ROLE_ADMIN;
        }

        BasicResponse basicResponse = userClient.Update().params("userId",userId).params("telephone",tel).
                params("userName",name).params("role",role).params("password",psw).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    //修改用户密码
    public String modifyPassword() {
        String userId = findUserId();
        if (userId==null || oldPSW ==null || newPSW ==null) {
            code=Signal.STATUS_INVALID_PARAMETER;
            message = Signal.MODIFY_PASSWORD_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = userClient.ModifyPasswod().params("userId",userId).params("oldPassword",oldPSW).params("newPassword",newPSW).execute();
        code = basicResponse.getErrorCode();
        message = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public String getRedirectUrl() {
        return redirectUrl;
    }
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserDetail> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetail> users) {
        this.users = users;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPSW() {
        return oldPSW;
    }

    public void setOldPSW(String oldPSW) {
        this.oldPSW = oldPSW;
    }

    public String getNewPSW() {
        return newPSW;
    }

    public void setNewPSW(String newPSW) {
        this.newPSW = newPSW;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getBannerLogoPath() {
        return bannerLogoPath;
    }

    public void setBannerLogoPath(String bannerLogoPath) {
        this.bannerLogoPath = bannerLogoPath;
    }

    public String getInnerLogoPath() {
        return innerLogoPath;
    }

    public void setInnerLogoPath(String innerLogoPath) {
        this.innerLogoPath = innerLogoPath;
    }

    public String getLandingLogoPath() {
        return landingLogoPath;
    }

    public void setLandingLogoPath(String landingLogoPath) {
        this.landingLogoPath = landingLogoPath;
    }
}
