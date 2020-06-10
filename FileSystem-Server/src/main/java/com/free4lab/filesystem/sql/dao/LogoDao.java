package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.sql.beans.LogoEntity;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by Idan on 2017/7/26.
 */
public class LogoDao extends AbstractDAO<LogoEntity> {

    private static LogoDao logoDao = new LogoDao();

    public static LogoDao getInstance() {return logoDao;}

    @Override
    public Class getEntityClass() {
        return LogoEntity.class;
    }

    @Override
    public String getPUName() {
        return Constants.PU_NAME;
    }

    @Override
    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }
}
