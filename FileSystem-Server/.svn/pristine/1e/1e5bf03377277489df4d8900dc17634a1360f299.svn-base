package com.free4lab.filesystem.search;

import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.beans.FileDetailEntity;
import com.free4lab.filesystem.sql.service.DirDetailService;
import com.free4lab.filesystem.sql.service.FileDetailEntityService;
import com.free4lab.filesystem.util.TikaUtil;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lizhenhao on 2017/6/14.
 */
public class SearchThread implements Runnable {

    private int timeSleep = 300;
    protected Logger logger = Logger.getLogger(SearchThread.class);

    private FileDetailEntityService fileDetailEntityService = FileDetailEntityService.getInstance();
    private DirDetailService dirDetailService = DirDetailService.getInstance();

    public void run() {
        while(true) {
            FileDetailEntity fileDetailEntity = SearchQueue.get();
            if (fileDetailEntity == null) {
                try {
                    Thread.sleep(timeSleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                if (fileDetailEntity.getFile() != null) {
                    String fileName = fileDetailEntity.getFileName();
                    try {
                        InputStream in = new FileInputStream(fileDetailEntity.getTextFilePath()+fileDetailEntity.getTextFileName());
                        String content = TikaUtil.parseFile(in,fileDetailEntity.getTextFileName());
                        logger.info(content);
                        if(content == null || content.equals("")) fileDetailEntity.setTikaStatus(ConstantEnum.STATUS_TYPE.FAIL);
                        else fileDetailEntity.setTikaStatus(ConstantEnum.STATUS_TYPE.SUCCESS);
                        fileDetailEntity.setContent(content);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        fileDetailEntity.setTikaStatus(ConstantEnum.STATUS_TYPE.FAIL);
                    }
                    fileDetailEntity.setUri(SearchUtil.addContent(fileDetailEntity.getContent(), fileName, fileDetailEntity));
                }
                else {
                    //更新标签
                    if(fileDetailEntity.getUri() != null) {
                        SearchUtil.updateTag(fileDetailEntity.getUri(),fileDetailEntity.getYear(),fileDetailEntity.getEventId(),fileDetailEntity.getDepartmentId(),fileDetailEntity.getEnterpriseId());
                    }
                }
                fileDetailEntityService.updateFile(fileDetailEntity);
                List list = dirDetailService.getByParam(null,fileDetailEntity.getYear(),null);
                if(list.size() == 0 || list == null)  {
                    dirDetailService.save(new DirDetailEntity(fileDetailEntity.getYear(), "TIME", fileDetailEntity.getEnterpriseId()));
                }
            }
        }
    }
}
