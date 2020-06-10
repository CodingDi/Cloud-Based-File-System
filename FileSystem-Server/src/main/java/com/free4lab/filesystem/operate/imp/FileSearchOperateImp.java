package com.free4lab.filesystem.operate.imp;

import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.FileSearchOperate;
import com.free4lab.filesystem.response.SearchDetail;
import com.free4lab.filesystem.response.SearchResponse;
import com.free4lab.filesystem.search.SearchUtil;
import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.beans.FileDetailEntity;
import com.free4lab.filesystem.sql.service.DirDetailService;
import com.free4lab.filesystem.sql.service.FileDetailEntityService;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.StringUtil;
import com.free4lab.search.common.bean.Document;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lizhenhao on 2017/6/12.
 */
@Component
public class FileSearchOperateImp implements FileSearchOperate {

    protected static Logger logger = Logger.getLogger(FileSearchOperateImp.class);

    private FileDetailEntityService fileDetailEntityService = FileDetailEntityService.getInstance();
    private DirDetailService dirDetailService = DirDetailService.getInstance();

    public SearchResponse findFiles(String eventId, String departmentId, String year,String enterpriseId) {
        List<SearchDetail> searchDetailList = fileDetailEntityService.findFilesByType(eventId,year,departmentId,enterpriseId);
        if(searchDetailList == null) {
            return new SearchResponse(Signal.FIND_FILE_ERROR,Signal.ERROR);
        }
        else {
            return new SearchResponse(searchDetailList, Signal.SUCCESS,Signal.OK,Signal.FIND);
        }
    }

    public SearchResponse searchFiles(String keyword, String eventId, String year, String departmentId,String enterpriseId) {
        /**
         * 标签用空格分开，可以进行多级标签搜索
         */
        String tag = "";
        if(!StringUtil.isNullOrEmpty(eventId)) tag = tag.concat(eventId).concat(" ").concat("AND ");
        if(!StringUtil.isNullOrEmpty(year)) tag = tag.concat(year).concat(" ").concat("AND ");
        if(!StringUtil.isNullOrEmpty(departmentId)) tag = tag.concat(departmentId).concat(" ").concat("AND ");
        tag = tag.concat(enterpriseId);
        try {
            List<Document> list = SearchUtil.findSearchContent(keyword,tag);
            List<SearchDetail> searchList = new ArrayList<SearchDetail>();
            for(Document document : list) {
                SearchDetail search = new SearchDetail();
                search.setTitle(document.getTitle());
                search.setContent(document.getContent());
                search.setDescribtion(document.getDescription());
                //通过uri查询
                FileDetailEntity fileDetailEntity = fileDetailEntityService.findFileByUri(document.getUri());
                if (fileDetailEntity != null) {
                    String eveId = fileDetailEntity.getEventId();
                    String depId = fileDetailEntity.getDepartmentId();
                    DirDetailEntity eveEntity = dirDetailService.getById(Integer.valueOf(eveId));
                    DirDetailEntity depEntity = dirDetailService.getById(Integer.valueOf(depId));
                    search.setDepartmentName(depEntity.getName());
                    search.setEventName(eveEntity.getName());
                    searchList.add(search);
                    EntityUtil.converJavaBean(search, fileDetailEntity);
                }
            }
            return new SearchResponse(searchList,Signal.SUCCESS,Signal.OK,Signal.SEARCH);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new SearchResponse(Signal.SEARCH_FILE_ERROR,Signal.ERROR);
        }
    }
}
