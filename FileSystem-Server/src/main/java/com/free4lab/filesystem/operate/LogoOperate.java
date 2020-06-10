package com.free4lab.filesystem.operate;

import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.LogoResponse;

/**
 * Created by lizhenhao on 2017/7/30.
 */
public interface LogoOperate {

    public LogoResponse save(String name,String type,String relativePath,String absolutePath,String relativePathServer,String absolutePathServer,String enterpriseId);

    public BasicResponse upadte(String id,String name, String type, String relativePath, String absolutePath, String relativePathServer, String absolutePathServer, String enterpriseId);

    public LogoResponse find(String enterpriseId);
}
