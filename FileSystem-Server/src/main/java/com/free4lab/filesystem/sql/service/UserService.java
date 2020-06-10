package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.response.UserDetail;
import com.free4lab.filesystem.sql.beans.UserEntity;
import com.free4lab.filesystem.sql.dao.UserDao;
import com.free4lab.filesystem.util.EntityUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/7/18.
 */
public class UserService {

    private static UserService userService = new UserService();

    public static UserService getInstance() {
        return userService;
    }

    public static UserDao userDao = UserDao.getInstance();

    public UserEntity getUser(String tel, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.TELEPHONE, tel);
        params.put(Constants.PASSWORD, password);
        List<UserEntity> list = userDao.findByProperty(params, null, null, null, false);
        if (list == null || list.size() == 0) {
            return null;
        } else return list.get(0);
    }

    public UserEntity getUserByTelAndRole(String tel, String role) {
        List<UserEntity> list = userDao.findByProperty2("telephone",tel,"role",role);
        if (list == null || list.size() == 0) {
            return null;
        } else return list.get(0);
    }

    public UserEntity findByUserId(Integer userId) {
        try {
            return userDao.findByPrimaryKey(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserDetail> findByRoleAnEnterpriseId (String role, String enterpriseId) {
        try {
            List<UserEntity> userEntities = new ArrayList<UserEntity>();
            if (role != null) {
                userEntities = userDao.findByProperty2("role", role, "enterpriseId", enterpriseId);
            } else {
                userEntities = userDao.findByProperty("enterpriseId", enterpriseId);
            }
            List<UserDetail> result = new ArrayList<UserDetail>();
            for (UserEntity user : userEntities) {
                UserDetail temp = new UserDetail();
                EntityUtil.converJavaBean(temp, user);
                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserDetail> findByRole(String role) {
        try {
            List<UserEntity> userEntities = userDao.findByProperty("role", role);
            List<UserDetail> result = new ArrayList<UserDetail>();
            for (UserEntity user : userEntities) {
                UserDetail temp = new UserDetail();
                EntityUtil.converJavaBean(temp, user);
                temp.setEnterpriseName(user.getEnterpriseEntity().getName());
                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void saveUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) {
        try {
            userDao.update(userEntity);
            return userEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUser(Integer userId) {
        try {
            userDao.deleteByPrimaryKey(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
