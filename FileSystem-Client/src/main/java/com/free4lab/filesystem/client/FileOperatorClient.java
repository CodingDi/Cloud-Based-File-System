package com.free4lab.filesystem.client;

import com.free4lab.filesystem.beans.JerseyResponse;
import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.BasicResponse;

/**
 * Created by lizhenhao on 2017/6/13.
 */
public class FileOperatorClient {

    private FileSystemClient CLIENT;

    public FileOperatorClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }


    public Save SaveFile() {
        return new Save();
    }

    public Delete DeleteFile() {
        return new Delete();
    }


    public Down DownFile() {
        return new Down();
    }


    public class Save extends FileSystemRequest<BasicResponse> {
        public Save() {
            super(CLIENT,null,"/fileResource/fileUpLoad",BasicResponse.class,HttpMethod.POST,null);
        }
    }

    public class Delete extends FileSystemRequest<BasicResponse> {
        public Delete() {
            super(CLIENT,null,"/fileResource/fileDelete",BasicResponse.class,HttpMethod.DELETE,null);
        }
    }

    public class Down extends FileSystemRequest<JerseyResponse> {
        public Down() {
            super(CLIENT,null,"/fileResource/fileDownLoad",null,HttpMethod.GET,null);
        }
    }



    public static void main(String args[]) {
        FileOperatorClient fileBasicClient = new FileOperatorClient("http://localhost:8081/FileSystem-Server/fileResource/");
        Delete delete = fileBasicClient.DeleteFile();
        BasicResponse basicResponse = delete.execute();
        System.out.println(basicResponse.getErrorCode());


    }
}
