package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.FileOperatorClient;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.util.ClientFactory;
import org.apache.log4j.Logger;

/**
 * Created by Idan on 2017/7/14.
 */
public class FileOperationAction extends BaseAction{

    private Logger logger = Logger.getLogger(FileOperationAction.class);
    private FileOperatorClient fileOperatorClient = ClientFactory.getFileOperatorClient();

    private String type;
    private String id;
    private String code;
    private String message;

    public String deleteByIdAndType() {
        FileOperatorClient.Delete delete = fileOperatorClient.DeleteFile();
        BasicResponse basicResponse = delete.params("id",id).params("type","all").execute();
        if (basicResponse.getErrorCode().equals(Signal.OK)) {
            code = Signal.OK;
            return SUCCESS;
        } else {
            code = basicResponse.getErrorCode();
            message = basicResponse.getErrorMessage();
            return ERROR;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
