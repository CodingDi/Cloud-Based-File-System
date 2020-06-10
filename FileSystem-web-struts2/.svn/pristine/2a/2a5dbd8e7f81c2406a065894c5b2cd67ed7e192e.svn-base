package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.FileOperatorClient;
import com.free4lab.filesystem.common.Entity;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.util.ClientFactory;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 * Created by lizhenhao on 2017/7/3.
 */
public class UpLoadAction extends BaseAction {

    protected Logger logger = Logger.getLogger(UpLoadAction.class);

    private String id;

    private String fileName;
    private File textFile;
    private String textFileFileName;
    private File picFile;
    private String picFileFileName;

    private String eventId;
    private String year;
    private String departmentId;
    private String type;

//    private String textErrorCode;
//    private String picErrorCode;
    private String errorCode;

    private FileOperatorClient fileOpClient = ClientFactory.getFileOperatorClient();

    public String execute() throws Exception {
        BasicResponse basicResponse;
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
//        save.path(id == null?"0":id).path("1").path(fileName).path(eventId).path(year).path(departmentId);
        formDataMultiPart.field("id",id == null?"0":id);
        formDataMultiPart.field("enterpriseId",(String) ActionContext.getContext().getSession().get("enterpriseId"));
        formDataMultiPart.field("fileName",fileName);
        formDataMultiPart.field("eventId",eventId);
        formDataMultiPart.field("departmentId",departmentId);
        formDataMultiPart.field("year",year);
        if (textFile != null && picFile == null) {
            formDataMultiPart.field("type","text");
            formDataMultiPart.field("text",textFile,MediaType.TEXT_PLAIN_TYPE);
            formDataMultiPart.field("textFileName",textFileFileName);
        }
        else if(textFile == null && picFile != null) {
            formDataMultiPart.field("type","pic");
            formDataMultiPart.field("pic",picFile,MediaType.TEXT_PLAIN_TYPE);
            formDataMultiPart.field("picFileName",picFileFileName);
        }
        else if(textFile != null && picFile != null){
            formDataMultiPart.field("type","all");
            formDataMultiPart.field("pic",picFile,MediaType.TEXT_PLAIN_TYPE);
            formDataMultiPart.field("picFileName",picFileFileName);
            formDataMultiPart.field("text",textFile,MediaType.TEXT_PLAIN_TYPE);
            formDataMultiPart.field("textFileName",textFileFileName);
        }
        else formDataMultiPart.field("type","none");
        FileOperatorClient.Save save = fileOpClient.SaveFile();
        save.setEntity(Entity.multiForm(formDataMultiPart));
        basicResponse = save.execute();
        errorCode = basicResponse.getErrorCode();

//        if(textFile != null) {
//            FileOperatorClient.Save save = fileOpClient.SaveFile();
//            save.path(id == null?"0":id).path("1").path(fileName).path(eventId).path(year).path(departmentId).path("text");
//            save.setEntity(Entity.multiForm(formDataMultiPart));
//            basicResponse = save.execute();
//            textErrorCode = basicResponse.getErrorCode();
//        }
//        if(picFile != null) {
//            FileOperatorClient.Save save = fileOpClient.SaveFile();
//            save.path(id).path("1").path(picFile.getName()).path(eventId).path(year).path(departmentId).path("pic");
//            save.setEntity(Entity.text(picFile));
//            basicResponse = save.execute();
//            picErrorCode = basicResponse.getErrorCode();
//        }
        return SUCCESS;
    }

    public File getTextFile() {
        return textFile;
    }

    public void setTextFile(File textFile) {
        this.textFile = textFile;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public File getPicFile() {
        return picFile;
    }

    public void setPicFile(File picFile) {
        this.picFile = picFile;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTextFileFileName() {
        return textFileFileName;
    }

    public void setTextFileFileName(String textFileFileName) {
        this.textFileFileName = textFileFileName;
    }

    public String getPicFileFileName() {
        return picFileFileName;
    }

    public void setPicFileFileName(String picFileFileName) {
        this.picFileFileName = picFileFileName;
    }
}

