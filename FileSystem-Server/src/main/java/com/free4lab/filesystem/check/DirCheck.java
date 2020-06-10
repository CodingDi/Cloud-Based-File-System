package com.free4lab.filesystem.check;

import com.free4lab.filesystem.common.ConstantEnum;

/**
 * Created by Idan on 2017/6/30.
 */
public class DirCheck {

    private static DirCheck dirCheck = new DirCheck();

    public static DirCheck getInstantce() {
        return dirCheck;
    }


    //检查type
    public boolean checkType(String type) {
        if (type.equals(ConstantEnum.DIR_TYPE.EVENT)) return true;
        else if (type.equals(ConstantEnum.DIR_TYPE.TIME)) return true;
        else if (type.equals(ConstantEnum.DIR_TYPE.DEPARTMENT)) return true;
        else return false;
    }

}
