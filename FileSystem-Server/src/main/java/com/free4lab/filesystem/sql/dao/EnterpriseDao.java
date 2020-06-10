package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.sql.beans.EnterpriseEntity;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by Idan on 2017/7/26.
 */
//@Component
public class EnterpriseDao extends AbstractDAO<EnterpriseEntity> {

    private static EnterpriseDao enterpriseDao = new EnterpriseDao();
//
    public static EnterpriseDao getInstance() {return enterpriseDao;}

    @Override
    public Class getEntityClass() {
        return EnterpriseEntity.class;
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
