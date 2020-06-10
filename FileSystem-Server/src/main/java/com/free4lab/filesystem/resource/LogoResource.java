package com.free4lab.filesystem.resource;

import com.free4lab.filesystem.operate.LogoOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.LogoResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by lizhenhao on 2017/7/30.
 */


@Path("logoResource")
@Controller
public class LogoResource {

    private Logger logger = Logger.getLogger(FileResource.class);
    @Autowired
    LogoOperate logoOperate;

    @Path("logoUpdate")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public BasicResponse userUpdateResult(@QueryParam("enterpriseId") String enterpriseId,
                                          @QueryParam("name") String name,
                                          @QueryParam("type") String type,
                                          @QueryParam("relativePath") String relativePath,
                                          @QueryParam("relativePathServer") String relativePathServer,
                                          @QueryParam("absolutePath") String absolutePath,
                                          @QueryParam("absolutePathServer") String absolutePathServer,
                                          @QueryParam("id") String id) {
        return logoOperate.upadte(id,name,type,relativePath,absolutePath,relativePathServer,absolutePathServer,enterpriseId);
    }

    @Path("logoFind")
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public LogoResponse enterpriseFindResult(@QueryParam("enterpriseId") String enterpriseId) {
        return logoOperate.find(enterpriseId);
    }

}
