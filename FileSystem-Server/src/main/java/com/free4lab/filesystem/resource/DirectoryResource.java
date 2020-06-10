package com.free4lab.filesystem.resource;

import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.DirectoryOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DirectoryResponse;
import com.free4lab.filesystem.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Idan on 2017/7/20.
 */

@Path("directoryResource")
@Controller
public class DirectoryResource {

    @Autowired
    private DirectoryOperate directoryOperate;

    /**
     * 查询目录
     * @return
     */
    @Path("directoryFind")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public DirectoryResponse dirFindResult(
            @QueryParam("type") String type,
            @QueryParam("kind") String kind,
            @QueryParam("enterpriseId") String enterpriseId) {
        if(StringUtil.isNullOrEmpty(enterpriseId)) {
            return new DirectoryResponse(Signal.STATUS_INVALID_PARAMETER,Signal.ERROR);
        }
        if(kind.equals("-1")) return directoryOperate.getDirectory(type,enterpriseId);
        else return directoryOperate.getDirectory(kind,type,enterpriseId);
    }

    /**
     * 创建目录
     * @return
     */
    @Path("directoryCreate")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse dirCreateResult(
            @FormParam ("directoryName") String dirName,
            @FormParam ("type") String type,
            @FormParam("enterpriseId") String enterpriseId) {
        //TODO 鉴权
        if (type == null || dirName == null) {
            return new BasicResponse(Signal.GET_DIR_ERROR,Signal.ERROR);
        }
        return directoryOperate.createDirectory(type,dirName,enterpriseId);
    }

    /**
     * 修改目录
     * @return
     */
    @Path("directoryUpdate")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse dirUpdateResult(
            @QueryParam ("directoryId") String dirId,
            @QueryParam ("directoryName") String name,
            @QueryParam ("type") String type) {
        return directoryOperate.updateDirectory(dirId,name,type);
    }

    /**
     * 删除目录
     * @return
     */
    @Path("directoryDetele")
    @DELETE
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse dirDeleteResult(
            @QueryParam ("directoryId") String dirId) {
        return directoryOperate.deleteDirectory(dirId);
    }
}
