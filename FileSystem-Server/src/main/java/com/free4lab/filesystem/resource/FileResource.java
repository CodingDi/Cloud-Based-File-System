package com.free4lab.filesystem.resource;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.DirectoryOperate;
import com.free4lab.filesystem.operate.FileBasicOperate;
import com.free4lab.filesystem.operate.FileSearchOperate;
import com.free4lab.filesystem.response.*;
import com.free4lab.filesystem.util.StringUtil;
import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件资源类，对外暴露的REST接口
 * Created by lizhenhao on 2017/2/16.
 */

@Path("fileResource")
@Controller
public class FileResource {

    private Logger logger = Logger.getLogger(FileResource.class);

    @Autowired
    FileBasicOperate fileBasicOperate;
    @Autowired
    FileSearchOperate fileSearchOperate;
    @Autowired
    private DirectoryOperate directoryOperate;

    /**
     * 删除文件
     * @return
     */
    @Path("fileDelete")
    @DELETE
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse fileDeleteResult(
            @QueryParam("id") String id,
            @QueryParam ("type") String type) {
        if(StringUtil.isNullOrEmpty(id)||StringUtil.isNullOrEmpty(type)) {
            return new BasicResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
        }
        return fileBasicOperate.deleteFile(id,type);
    }


    /**
     * 上传文件
     * @return
     */
    @Path("fileUpLoad")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse fileUpLoadResult(
            @FormDataParam("fileName") String fileName,
            @FormDataParam ("enterpriseId") String enterpriseId,
            @FormDataParam ("eventId") String eventId,
            @FormDataParam ("year") String year,
            @FormDataParam ("departmentId") String departmentId,
            @FormDataParam ("type") String type,
            @FormDataParam ("id") String id,
            @FormDataParam ("textFileName") String textFileName,
            @FormDataParam ("picFileName") String picFileName,
            @FormDataParam ("text") InputStream textFile,
            @FormDataParam ("pic") InputStream picFile){

        if(StringUtil.isNullOrEmpty(enterpriseId)||StringUtil.isNullOrEmpty(eventId)||StringUtil.isNullOrEmpty(year)||StringUtil.isNullOrEmpty(departmentId)||StringUtil.isNullOrEmpty(type)) {
            return new BasicResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
        }
        Map<String,InputStream> fileMap = new HashMap();
        try {
            if (textFile != null) {
                fileMap.put(Constants.TEXT, StringUtil.streamRefresh(textFile));
            }
            if (picFile != null) {
                fileMap.put(Constants.PIC,StringUtil.streamRefresh(picFile));
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            return new BasicResponse(Signal.DEFAULT_ERROR,Signal.ERROR);
        }


        Map<String,String> fileNameMap = new HashMap();
        fileNameMap.put("fileName",fileName);
        fileNameMap.put(Constants.TEXT,textFileName);
        fileNameMap.put(Constants.PIC,picFileName);
        return fileBasicOperate.saveFile(fileMap,fileNameMap,eventId,year,departmentId,enterpriseId,type,id);
    }

    /**
     * 下载文件
     * @param path
     * @return
     */
    @Path("fileDownLoad")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public InputStream fileDownLoadResult(
            @QueryParam("path") String path,
            @Context HttpServletResponse response) {
        if(StringUtil.isNullOrEmpty(path)) {
            response.setHeader("status", Signal.STATUS_INVALID_PARAMETER);
            return null;
        }
        DownFileResponse downFileResponse = fileBasicOperate.downFile(path);
        response.setHeader("fileLength", String.valueOf(downFileResponse.getContentLength()));
        response.setHeader("fileType",downFileResponse.getContentType());
        response.setHeader("contentDisposition",downFileResponse.getContentDisposition());
        response.setCharacterEncoding("UTF-8");
        if(downFileResponse.getErrorCode().equals(Signal.OK)) {
            response.setHeader("status",downFileResponse.getErrorCode());
            return downFileResponse.getInputStream();
        }
        else {
            logger.info("返回值为空");
            response.setHeader("status",downFileResponse.getErrorCode());
            return null;
        }
    }

    /**
     * 查找文件
     * @param eventId
     * @param year
     * @param departmentId
     * @param keyword
     * @param enterpriseId
     * @return
     */
    @Path("fileSearch")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public SearchResponse fileSearchResult(
            @QueryParam("eventId") String eventId,
            @QueryParam("year") String year,
            @QueryParam("departmentId") String departmentId,
            @QueryParam("keyword") String keyword,
            @QueryParam("enterpriseId") String enterpriseId) {
        if(StringUtil.isNullOrEmpty(enterpriseId)) {
            return new SearchResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
        }
        return fileSearchOperate.searchFiles(keyword,eventId,year,departmentId,enterpriseId);
    }

    @Path("fileFind")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public SearchResponse fileFindResult(
            @QueryParam("eventId") String eventId,
            @QueryParam("year") String year,
            @QueryParam("departmentId") String departmentId,
            @QueryParam("enterpriseId") String enterpriseId) {
        if(StringUtil.isNullOrEmpty(enterpriseId)) {
            return new SearchResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
        }
        return fileSearchOperate.findFiles(eventId,departmentId,year,enterpriseId);
    }
}
