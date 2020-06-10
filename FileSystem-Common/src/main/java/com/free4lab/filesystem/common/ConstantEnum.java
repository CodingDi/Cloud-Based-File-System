package com.free4lab.filesystem.common;

import com.free4lab.filesystem.response.DirDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Idan on 2017/6/30.
 */
public class ConstantEnum {

    public static List<Map<String,DirDetail>> dirTypeList = new ArrayList<Map<String,DirDetail>>();

    public static Map<String,DirDetail> eventMap = new HashMap<String, DirDetail>();
    public static Map<String,DirDetail> timeMap = new HashMap<String, DirDetail>();
    public static Map<String,DirDetail> departmentMap = new HashMap<String, DirDetail>();

    static {
        //第一种类型:年度
        timeMap.put(DIR_TYPE.INIT,new DirDetail(DIR_TYPE.TIME,true));
        timeMap.put(DIR_TYPE.TIME,new DirDetail(DIR_TYPE.DEPARTMENT,true));
        timeMap.put(DIR_TYPE.DEPARTMENT,new DirDetail(DIR_TYPE.EVENT,false));
        dirTypeList.add(timeMap);

        //第二种类型:事件
        eventMap.put(DIR_TYPE.INIT,new DirDetail(DIR_TYPE.EVENT,true));
        eventMap.put(DIR_TYPE.EVENT,new DirDetail(DIR_TYPE.DEPARTMENT,true));
        eventMap.put(DIR_TYPE.DEPARTMENT,new DirDetail(DIR_TYPE.TIME,false));
        dirTypeList.add(eventMap);

        //第三种类型:部门
        departmentMap.put(DIR_TYPE.INIT,new DirDetail(DIR_TYPE.DEPARTMENT,true));
        departmentMap.put(DIR_TYPE.DEPARTMENT,new DirDetail(DIR_TYPE.TIME,true));
        departmentMap.put(DIR_TYPE.TIME,new DirDetail(DIR_TYPE.EVENT,false));
        dirTypeList.add(departmentMap);
    }

    //文件加的类型
    public static class DIR_TYPE {
        public static final String INIT = "INIT";
        public static final String EVENT = "EVENT";
        public static final String TIME = "TIME";
        public static final String DEPARTMENT = "DEPARTMENT";
    }

    public static class USER_ROLE {
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_USER";
        public static final String ROLE_ROOT = "ROLE_ROOT";
    }

    public static class LOGO_TYPE {
        public static final String BANNER = "BANNER";
        public static final String LOGO_INNER = "LOGO_INNER";
        public static final String LOGO_LANDING = "LOGO_LANDING";
    }

    public static class STATUS_TYPE {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAIL = "FAIL";
    }

}
