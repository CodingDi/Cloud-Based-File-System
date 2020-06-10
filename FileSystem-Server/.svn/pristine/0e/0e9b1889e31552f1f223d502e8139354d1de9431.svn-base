package com.free4lab.filesystem.operate;

import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DirectoryResponse;

/**
 * Created by lizhenhao on 2017/6/8.
 */
public interface DirectoryOperate {

    // 分类型查
    public DirectoryResponse getDirectory(String kind,String type,String enterpriseId);

    public DirectoryResponse getDirectory(String type,String enterpriseId);

    public BasicResponse createDirectory(String type,String dirName,String enterpriseId);

    public BasicResponse updateDirectory(String dirId, String name,String type);

    public BasicResponse deleteDirectory(String dirId);
}
