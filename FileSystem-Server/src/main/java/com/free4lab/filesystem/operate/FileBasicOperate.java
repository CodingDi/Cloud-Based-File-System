package com.free4lab.filesystem.operate;

import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DownFileResponse;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/6/12.
 */
public interface FileBasicOperate {

    /**
     * 删除文件
     * @return
     */
    public BasicResponse deleteFile(String id,String type);
    /**
     * 保存上传的文件
     * @param file
     * @param fileName
     * @return
     */
    public BasicResponse saveFile(Map<String,InputStream> file, Map<String,String> fileName, String eventId, String year, String departmentId, String enterpriseId, String type, String id);
    /**
     * 下载文件
     * @param path
     * @return
     */
    public DownFileResponse downFile(String path);

}
