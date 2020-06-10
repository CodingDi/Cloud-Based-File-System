package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.DirectoryClient;
import com.free4lab.filesystem.common.DirectoryType;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DirDetail;
import com.free4lab.filesystem.response.DirectoryResponse;
import com.free4lab.filesystem.util.ClientFactory;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Form;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Idan on 2017/7/5.
 */
public class DirectoryAction extends BaseAction{

    private Logger logger = Logger.getLogger(DirectoryAction.class);

    private DirectoryClient directoryClient = ClientFactory.getDirectoryClient();


    private String errorCode;
    private String errorMessage;
    /**
     * 异步加载目录
     *
     */
    private String kind;
    private String type;
    private String enterpriseId;
    private String dirName;
    private int pid;
    private List<DirDetail> dirList;
    private String dirId;

    private List<DirDetail> eventDirList;
    private List<DirDetail> departmentDirList;

    /**
     * 为目录树服务的查找函数
     * @return
     */
    //获得目录
    public String findDirectory() {
        String enterpriseId = this.findEnterpriseId();
        DirectoryResponse directoryResponse = directoryClient.FindDirectory().params("kind",kind).params("type",type).params("enterpriseId",enterpriseId).execute();
        if (directoryResponse.getErrorCode().equals(Signal.OK)) {
            dirList = directoryResponse.getDirList();
            for (int i=0;i<dirList.size();i++) {
                dirList.get(i).setpId(pid);
            }
            Gson gson = new Gson();
            getPrintWriter().write(gson.toJson(dirList));
            return SUCCESS;
        } else {
            logger.error(directoryResponse.getErrorMessage());
            return ERROR;
        }
    }



    //获得不同类型的目录
    public String findDirectoryByType() {
        String enterpriseId = this.findEnterpriseId();
        DirectoryResponse dirResponse = directoryClient.FindDirectory().params("kind",kind).params("type","INIT").params("enterpriseId",enterpriseId).execute();
        errorCode = dirResponse.getErrorCode();
        dirList = dirResponse.getDirList();
        return SUCCESS;
    }

    /**
     * 高级搜索下拉框内容填充
     * @return
     */
    public String findAllDirectoryByType() {
        String enterpriseId = this.findEnterpriseId();
        DirectoryResponse eventDirResponse = directoryClient.FindDirectory().params("kind","1").params("type","INIT").params("enterpriseId",enterpriseId).execute();
        DirectoryResponse departmentDirResponse = directoryClient.FindDirectory().params("kind","2").params("type","INIT").params("enterpriseId",enterpriseId).execute();
        errorCode = eventDirResponse.getErrorCode();
        eventDirList = eventDirResponse.getDirList();
        departmentDirList = departmentDirResponse.getDirList();
        return SUCCESS;
    }

    public String deleteById() {
        if (dirId==null) {
            errorCode=Signal.STATUS_INVALID_PARAMETER;
            errorMessage = Signal.DELETE_USER_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = directoryClient.Delete().params("directoryId",dirId).execute();
        errorCode = basicResponse.getErrorCode();
        errorMessage = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    public String updateDirectory() {
        if (dirId==null) {
            errorCode=Signal.STATUS_INVALID_PARAMETER;
            errorMessage = Signal.DELETE_USER_ERROR;
            return SUCCESS;
        }
        BasicResponse basicResponse = directoryClient.Update().params("directoryId",dirId).
                params("directoryName",dirName).params("type",type).execute();
        errorCode = basicResponse.getErrorCode();
        errorMessage = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    /**
     * 获得HttpServletResponse对象
     * @return
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        return response;
    }

    public PrintWriter getPrintWriter() {
        PrintWriter pw = null;
        try {
            pw = getResponse().getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pw;
    }



    /**
     * 上传文件时，获取所有目录
      */

    private List<DirDetail> yearDirectoryList;

    private List<DirDetail> departmentDirectoryList;

    private List<DirDetail> eventDirectoryList;

    private String eventId;
    private String departmentId;
    private String year;
    private String id;
    private String textFileName;
    private String picFileName;
    private String fileName;

    public String acquireAllDirectory() {
        yearDirectoryList = acquireDirectory(DirectoryType.TIME);
        departmentDirectoryList = acquireDirectory(DirectoryType.DEPARTMENT);
        eventDirectoryList = acquireDirectory(DirectoryType.EVENT);
        if(yearDirectoryList != null && departmentDirectoryList!=null && eventDirectoryList!=null) {
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
    private List<DirDetail> acquireDirectory(DirectoryType type) {
        String enterpriseId = this.findEnterpriseId();
        DirectoryResponse directoryResponse = directoryClient.FindDirectory().params("type", type.name()).params("kind","-1").params("enterpriseId",enterpriseId).execute();
        if(directoryResponse.getErrorCode().equals(Signal.OK)) {
            return directoryResponse.getDirList();
        }
        else {
            logger.error(directoryResponse.getErrorMessage());
            return null;
        }
    }

    public String createDirectory() {
        String enterpriseId = this.findEnterpriseId();
        Form form = new Form();
        form.param("type",type);
        form.param("directoryName",dirName);
        form.param("enterpriseId",enterpriseId);
        BasicResponse basicResponse = directoryClient.CreateDirectory(form).execute();
        errorCode = basicResponse.getErrorCode();
        return SUCCESS;
    }


    public List<DirDetail> getEventDirList() {
        return eventDirList;
    }

    public void setEventDirList(List<DirDetail> eventDirList) {
        this.eventDirList = eventDirList;
    }

    public List<DirDetail> getDepartmentDirList() {
        return departmentDirList;
    }

    public void setDepartmentDirList(List<DirDetail> departmentDirList) {
        this.departmentDirList = departmentDirList;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<DirDetail> getDirList() {
        return dirList;
    }

    public void setDirList(List<DirDetail> dirList) {
        this.dirList = dirList;
    }

    public List<DirDetail> getYearDirectoryList() {
        return yearDirectoryList;
    }

    public void setYearDirectoryList(List<DirDetail> yearDirectoryList) {
        this.yearDirectoryList = yearDirectoryList;
    }

    public List<DirDetail> getDepartmentDirectoryList() {
        return departmentDirectoryList;
    }

    public void setDepartmentDirectoryList(List<DirDetail> departmentDirectoryList) {
        this.departmentDirectoryList = departmentDirectoryList;
    }

    public List<DirDetail> getEventDirectoryList() {
        return eventDirectoryList;
    }

    public void setEventDirectoryList(List<DirDetail> eventDirectoryList) {
        this.eventDirectoryList = eventDirectoryList;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
