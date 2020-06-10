package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.response.EnterpriseDetail;
import com.free4lab.filesystem.sql.beans.EnterpriseEntity;
import com.free4lab.filesystem.sql.dao.EnterpriseDao;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan on 2017/7/26.
 */
@Component
public class EnterpriseService {

    private EnterpriseDao enterpriseDao = EnterpriseDao.getInstance();

//    @Autowired
//    private EnterpriseDao enterpriseDao;

    private static EnterpriseService enterpriseService = new EnterpriseService();

    public static EnterpriseService getInstance() {return enterpriseService;}

    //添加
    public EnterpriseEntity save(EnterpriseEntity entity) {
        try {
            enterpriseDao.save(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //删除
    public Boolean deleteById(Integer enterpriseId) {
        try {
            enterpriseDao.deleteByPrimaryKey(enterpriseId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //修改
    public EnterpriseEntity update(EnterpriseEntity enterpriseEntity) {
        try {
            return enterpriseDao.update(enterpriseEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询
    public List<EnterpriseDetail> getAllEnterprise() {
        try {
            List<EnterpriseEntity> enterpriseEntities = enterpriseDao.findAll();
            List<EnterpriseDetail> result = new ArrayList<EnterpriseDetail>();
            for (EnterpriseEntity entity:enterpriseEntities) {
                EnterpriseDetail temp = new EnterpriseDetail();
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

    public boolean findByName(String name) {
        return enterpriseDao.findByProperty("name",name).size()!=0;
    }

    public EnterpriseEntity findById(Integer enterpriseId) {
        return enterpriseDao.findByPrimaryKey(enterpriseId);
    }

}
