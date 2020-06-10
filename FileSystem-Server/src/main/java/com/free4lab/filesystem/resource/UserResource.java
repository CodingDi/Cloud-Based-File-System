package com.free4lab.filesystem.resource;

import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.UserOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.UserResponse;
import com.free4lab.filesystem.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by lizhenhao on 2017/7/18.
 */

@Path("userResource")
@Controller
public class UserResource {
    private Logger logger = Logger.getLogger(UserResource.class);

    @Autowired
    UserOperate userOperate;

    @Path("userFind")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public UserResponse userFindResult(@QueryParam("telephone") String tele,
                                       @QueryParam("password") String password
                                       ) {
        if(StringUtil.isNullOrEmpty(tele) || StringUtil.isNullOrEmpty(password))
            return new UserResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
       return userOperate.findUser(tele,password);
    }

    @Path("userFindByRoleAnEnterpriseId")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public UserResponse userFindByRoleResult(@QueryParam("role") String role,
                                       @QueryParam("enterpriseId") String enterpriseId) {
        return userOperate.findByRoleAnEnterpriseId(role,enterpriseId);
    }

    @Path("userFindByRole")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public UserResponse userFindByRoleResult(@QueryParam("role") String role) {
        return userOperate.findUserByRole(role);
    }

    @Path("userCreate")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse userAddResult(@FormParam("userName") String userName,
                                       @FormParam("role") String role,
                                       @FormParam("enterpriseId") String enterpriseId,
                                       @FormParam("telephone") String tel,
                                       @FormParam("password") String password) {
        return userOperate.saveUser(userName,role,enterpriseId,tel,password);
    }

    @Path("userUpdate")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse userUpdateResult(@QueryParam("userId") String userId,
                                         @QueryParam("telephone") String tel,
                                         @QueryParam("userName") String userName,
                                         @QueryParam("role") String role,
                                         @QueryParam("password") String password) {
        return userOperate.updateUser(userId,userName,role,tel,password);
    }

    @Path("modifyPassword")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse userUpdateResult(@QueryParam("userId") String userId,
                                          @QueryParam("oldPassword") String oldPassword,
                                          @QueryParam("newPassword") String newPassword) {
        return userOperate.modifyPassword(userId,oldPassword,newPassword);
    }

    @Path("userDelete")
    @DELETE
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse userDeleteResult(@QueryParam("userId") String userId) {
        return userOperate.deleteUser(userId);
    }
}
