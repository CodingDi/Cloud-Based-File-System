package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.sql.beans.UserEntity;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by lizhenhao on 2017/7/18.
 */
public class UserDao extends AbstractDAO<UserEntity> {

    private static UserDao userDao = new UserDao();

    public static UserDao getInstance() {
        return userDao;
    }

    @Override
    public Class getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public String getPUName() {
        return "VMC_PU";
    }

    @Override
    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }
}
