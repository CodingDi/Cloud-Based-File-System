package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.sql.beans.FileDetailEntity;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by lizhenhao on 2017/2/27.
 */
public class FileDetailEntityDao extends AbstractDAO<FileDetailEntity> {

    private static FileDetailEntityDao fileDetailContentDao = new FileDetailEntityDao();

    public static FileDetailEntityDao getInstance() {
        return fileDetailContentDao;
    }

    public Class getEntityClass() {
        return FileDetailEntity.class;
    }

    public String getPUName() {
        return "VMC_PU";
    }

    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }


}
