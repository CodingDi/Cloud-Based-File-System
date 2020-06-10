package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.LogoResponse;

/**
 * Created by lizhenhao on 2017/7/30.
 */
public class LogoClient {

    private FileSystemClient CLIENT;

    public LogoClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }

    public Find Find() {
        return new Find();
    }

    public Update Update() {
        return new Update();
    }

    public class Find extends FileSystemRequest<LogoResponse> {
        public Find() {
            super(CLIENT,null,"/logoResource/logoFind",LogoResponse.class,HttpMethod.GET,null);
        }
    }

    public class Update extends FileSystemRequest<BasicResponse> {
        public Update() {
            super(CLIENT,null,"/logoResource/logoUpdate",BasicResponse.class,HttpMethod.GET,null);
        }
    }

}
