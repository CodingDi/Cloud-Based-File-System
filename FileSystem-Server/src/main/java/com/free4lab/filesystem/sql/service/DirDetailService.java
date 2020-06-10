package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.response.DirDetail;
import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.dao.DirDetailDao;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.StringUtil;
import com.free4lab.filesystem.util.TimeUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Idan on 2017/6/12.
 */
public class DirDetailService {

    protected Logger logger = Logger.getLogger(DirDetailService.class);

    private static DirDetailService dirDetailService = new DirDetailService();

    public static DirDetailService getInstance() {
        return dirDetailService;
    }

    private DirDetailDao dirDetailDao = DirDetailDao.getInstance();

    //增加
    public DirDetailEntity save(DirDetailEntity entity) {
        try {
            dirDetailDao.save(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //查找
    public List<DirDetailEntity> getByParam(String type, String dirName, String enterpriseId) {
        Map<String,Object> searchMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(dirName)) {
            searchMap.put("name",dirName);
        }
        if (!StringUtil.isNullOrEmpty(type)) {
            searchMap.put("type",type);
        }
        if (!StringUtil.isNullOrEmpty(enterpriseId)) {
            searchMap.put("enterpriseId",enterpriseId);
        }
        try {
            List<DirDetailEntity> resultTemp = dirDetailDao.findByProperty(searchMap,null,null,null,false);
            return resultTemp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //1.年度->部门->事件
    //2.部门->年度->事件
    //3.事件->部门->年度
    public List<DirDetail> getByType(String type, String enterpriseId) {
        Map<String,Object> searchMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(type)) {
            searchMap.put(Constants.TYPE,type);
        }
        searchMap.put(Constants.ENTERPRISEID,enterpriseId);
        try {
            List<DirDetailEntity> resultTemp = dirDetailDao.findByProperty(searchMap,null,null,null,false);
            List<DirDetail> result = new ArrayList<DirDetail>();
            for (DirDetailEntity entity:resultTemp) {
                DirDetail temp = new DirDetail();
                EntityUtil.converJavaBean(temp,entity);
//                temp.setName(entity.getName());
                logger.info(temp.getName());
                logger.info(entity.getName());
                temp.setDate(TimeUtil.ConverToString(entity.getCreateDate()));
                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DirDetailEntity getById(Integer dirId) {
        try {
            DirDetailEntity result = dirDetailDao.findByPrimaryKey(dirId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DirDetailEntity update(DirDetailEntity entity) {
        try {
            return dirDetailDao.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean deteleById(Integer dirId) {
        try {
            dirDetailDao.deleteByPrimaryKey(dirId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
