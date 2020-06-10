package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.response.SearchDetail;
import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.beans.FileDetailEntity;
import com.free4lab.filesystem.sql.dao.FileDetailEntityDao;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/6/12.
 */
public class FileDetailEntityService {

    private FileDetailEntityDao fileDetailEntityDao = FileDetailEntityDao.getInstance();
    private DirDetailService dirDetailService = DirDetailService.getInstance();

    private static FileDetailEntityService fileDetailEntityService = new FileDetailEntityService();
    public static FileDetailEntityService getInstance(){
        return fileDetailEntityService;
    }

    public FileDetailEntity findSingleFile(String fileName,String enterpriseId) {
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put(Constants.FILENAME,fileName);
        map.put(Constants.ENTERPRISEID,enterpriseId);
        List<FileDetailEntity> list = fileDetailEntityDao.findByProperty(map,null,null,null,false);
        if(list.size() != 0 && list != null)
            return list.get(0);
        else return null;
    }

    public FileDetailEntity findSingleFile(String id) {
        return fileDetailEntityDao.findByPrimaryKey(Integer.valueOf(id));
    }

    public FileDetailEntity findFileByUri(String uri) {
        List<FileDetailEntity> list = fileDetailEntityDao.findByProperty("uri",uri);
        if(list == null || list.size() == 0) return null;
        else return list.get(0);
    }

    public List<SearchDetail> findFilesByType(String eventId,String year,String departmentId,String enterpriseId) {
        Map<String,Object> property = new HashMap<String,Object>();
        if (!StringUtil.isNullOrEmpty(eventId)) property.put(Constants.EVENTID,eventId);
        if (!StringUtil.isNullOrEmpty(year)) property.put(Constants.TIME,year);
        if (!StringUtil.isNullOrEmpty(departmentId)) property.put(Constants.DEPARTMENTID,departmentId);
        property.put(Constants.ENTERPRISEID,enterpriseId);
        List<FileDetailEntity> fileDetailEntities = fileDetailEntityDao.findByProperty(property,null,null,null,false);

        if (fileDetailEntities.size() == 0 || fileDetailEntities == null) return null;
        List<SearchDetail> searchDetails = new ArrayList<SearchDetail>();
        for(FileDetailEntity temp : fileDetailEntities) {
            String eveId = temp.getEventId();
            String depId = temp.getDepartmentId();
            DirDetailEntity eveEntity = dirDetailService.getById(Integer.valueOf(eveId));
            DirDetailEntity depEntity = dirDetailService.getById(Integer.valueOf(depId));
            SearchDetail searchDetail = new SearchDetail();
            EntityUtil.converJavaBean(searchDetail,temp);
            searchDetail.setDepartmentName(depEntity.getName());
            searchDetail.setEventName(eveEntity.getName());
            searchDetails.add(searchDetail);
        }
        return searchDetails;
    }


    public void saveFile(FileDetailEntity fileDetailEntity) {
        fileDetailEntityDao.save(fileDetailEntity);
    }

    public void updateFile(FileDetailEntity fileDetailEntity) {
        fileDetailEntityDao.update(fileDetailEntity);
    }

    public void deleteFile(FileDetailEntity fileDetailEntity) {
        fileDetailEntityDao.deleteByPrimaryKey(fileDetailEntity.getId());
    }
}
