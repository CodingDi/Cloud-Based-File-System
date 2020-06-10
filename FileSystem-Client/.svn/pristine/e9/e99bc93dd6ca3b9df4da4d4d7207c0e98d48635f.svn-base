package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.Entity;
import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.UserResponse;

/**
 * Created by lizhenhao on 2017/7/18.
 */
public class UserClient {

    private FileSystemClient CLIENT;

    public UserClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }

    public UserClient.Login Login() {
        return new UserClient.Login();
    }

    public UserClient.Save Save(Object form) {
        return new UserClient.Save(form);
    }

    public UserClient.Find Find() {
        return new UserClient.Find();
    }

    public UserClient.FindByRole FindByRole() {
        return new UserClient.FindByRole();
    }

    public UserClient.Update Update() {
        return new UserClient.Update();
    }

    public UserClient.ModifyPasswod ModifyPasswod() {
        return new UserClient.ModifyPasswod();
    }


    public UserClient.Delete Delete() {
        return new UserClient.Delete();
    }

    public class Login extends FileSystemRequest<UserResponse> {
        public Login() {
            super(CLIENT,null,"/userResource/userFind",UserResponse.class, HttpMethod.GET,null);
        }
    }

    public class Save extends FileSystemRequest<BasicResponse> {
        public Save(Object form) {
            super(CLIENT,null,"/userResource/userCreate",BasicResponse.class,HttpMethod.POST, Entity.form(form));
        }
    }

    public class Find extends FileSystemRequest<BasicResponse> {
        public Find() {
            super(CLIENT,null,"/userResource/userFindByRoleAnEnterpriseId",UserResponse.class,HttpMethod.GET,null);
        }
    }

    public class FindByRole extends FileSystemRequest<BasicResponse> {
        public FindByRole() {
            super(CLIENT,null,"/userResource/userFindByRole",UserResponse.class,HttpMethod.GET,null);
        }
    }

    public class Update extends FileSystemRequest<BasicResponse> {
        public Update() {
            super(CLIENT,null,"/userResource/userUpdate",BasicResponse.class,HttpMethod.GET,null);
        }
    }

    public class ModifyPasswod extends FileSystemRequest<BasicResponse> {
        public ModifyPasswod() {
            super(CLIENT,null,"/userResource/modifyPassword",BasicResponse.class,HttpMethod.GET,null);
        }
    }

    public class Delete extends FileSystemRequest<BasicResponse> {
        public Delete() {
            super(CLIENT,null,"/userResource/userDelete",BasicResponse.class,HttpMethod.DELETE,null);
        }
    }
}
