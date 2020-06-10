package com.free4lab.filesystem.sql.dao;

import com.free4lab.filesystem.sql.beans.DirTreeContent;
import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import com.free4lab.filesystem.sql.helper.NoCacheEntityManagerHelper;

/**
 * Created by lizhenhao on 2017/2/27.
 */
public class DirTreeContentDao extends AbstractDAO<DirTreeContent> {
    public Class getEntityClass() {
        return DirTreeContent.class;
    }

    public String getPUName() {
        return "VMC_PU";
    }

    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }


}
