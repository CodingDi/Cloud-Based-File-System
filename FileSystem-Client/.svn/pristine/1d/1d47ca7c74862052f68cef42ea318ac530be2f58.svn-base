package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.Entity;
import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DirectoryResponse;

/**
 * Created by lizhenhao on 2017/7/3.
 */
public class DirectoryClient {

    private FileSystemClient CLIENT;

    public DirectoryClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }


    public Find FindDirectory() {
        return new Find();
    }

    public Create CreateDirectory(Object form) {
        return new Create(form);
    }

    public Update Update() {
        return new Update();
    }

    public Delete Delete() {
        return new Delete();
    }

    public class Find extends FileSystemRequest<DirectoryResponse> {
        public Find() {
            super(CLIENT,null,"/directoryResource/directoryFind",DirectoryResponse.class, HttpMethod.GET,null);
        }
    }

    public class Create extends FileSystemRequest<BasicResponse> {
        public Create(Object form) {
            super(CLIENT,null,"/directoryResource/directoryCreate",BasicResponse.class,HttpMethod.POST, Entity.form(form));
        }
    }

    public class Update extends FileSystemRequest<BasicResponse> {
        public Update() {
            super(CLIENT,null,"/directoryResource/directoryUpdate",BasicResponse.class,HttpMethod.GET, null);
        }
    }

    public class Delete extends FileSystemRequest<BasicResponse> {
        public Delete() {
            super(CLIENT,null,"/directoryResource/directoryDetele",BasicResponse.class,HttpMethod.DELETE, null);
        }
    }

    public static void main(String args[]) {
        DirectoryClient fileBasicClient = new DirectoryClient("http://localhost:8081/FileSystem-Server/fileResource/");
        Find find = fileBasicClient.FindDirectory();
        DirectoryResponse directoryResponse = find.params("kind","0").params("type","INIT").params("userId",null).execute();
        System.out.println(directoryResponse.getErrorCode());
    }

}
