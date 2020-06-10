package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.Entity;
import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.EnterpriseResponse;

/**
 * Created by lizhenhao on 2017/7/18.
 */
public class EnterpriseClient {

    private FileSystemClient CLIENT;

    public EnterpriseClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }

    public Save Save(Object form) {
        return new Save(form);
    }

    public Find Find() {
        return new Find();
    }

    public Update Update() {
        return new Update();
    }

    public Delete Delete() {
        return new Delete();
    }


    public class Save extends FileSystemRequest<BasicResponse> {
        public Save(Object form) {
            super(CLIENT,null,"/enterpriseResource/enterpriseCreate",BasicResponse.class,HttpMethod.POST, Entity.form(form));
        }
    }

    public class Find extends FileSystemRequest<EnterpriseResponse> {
        public Find() {
            super(CLIENT,null,"/enterpriseResource/enterpriseFind",EnterpriseResponse.class,HttpMethod.GET,null);
        }
    }

    public class Update extends FileSystemRequest<BasicResponse> {
        public Update() {
            super(CLIENT,null,"/enterpriseResource/enterpriseUpdate",BasicResponse.class,HttpMethod.GET,null);
        }
    }

    public class Delete extends FileSystemRequest<BasicResponse> {
        public Delete() {
            super(CLIENT,null,"/enterpriseResource/enterpriseDelete",BasicResponse.class,HttpMethod.DELETE,null);
        }
    }
}
