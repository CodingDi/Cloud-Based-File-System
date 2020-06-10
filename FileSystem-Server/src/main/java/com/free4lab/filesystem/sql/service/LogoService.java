package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.response.LogoDetail;
import com.free4lab.filesystem.sql.beans.LogoEntity;
import com.free4lab.filesystem.sql.dao.LogoDao;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Idan on 2017/7/26.
 */
@Component
public class LogoService {

    private LogoDao logoDao = LogoDao.getInstance();

    private static LogoService logoService = new LogoService();

    public static LogoService getInstance() {return logoService;}

    //添加
    public LogoEntity save(LogoEntity logoEntity) {
        try {
            logoDao.save(logoEntity);

            return logoEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //修改
    public LogoEntity update(LogoEntity logoEntity) {
        try {
            return logoDao.update(logoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询
    public List<LogoDetail> getAllLogoByInterpriseId(String enterpriseId) {
        try {
            Map<String,Object> params = new HashMap<String ,Object>();
            params.put(Constants.ENTERPRISEID,enterpriseId);
            List<LogoEntity> logoEntities = logoDao.findByProperty(params,null,null,Constants.TYPE,true);
            List<LogoDetail> result = new ArrayList<LogoDetail>();
            for (LogoEntity entity:logoEntities) {
                LogoDetail temp = new LogoDetail();
                EntityUtil.converJavaBean(temp,entity);
                temp.setDate(TimeUtil.ConverToString(entity.getCreateDate()));
                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询
    public LogoEntity getLogoById(String id) {
        try {
          return logoDao.findById(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
