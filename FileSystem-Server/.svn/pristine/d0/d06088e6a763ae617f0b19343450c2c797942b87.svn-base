package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by lizhenhao on 2017/2/27.
 */
public class DirDetailDao extends AbstractDAO<DirDetailEntity> {

    private static DirDetailDao dirDetailDao = new DirDetailDao();

    public static DirDetailDao getInstance() {
        return dirDetailDao;
    }

    public Class getEntityClass() {
        return DirDetailEntity.class;
    }

    public String getPUName() {
        return "VMC_PU";
    }

    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }


}
