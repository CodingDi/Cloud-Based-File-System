package com.free4lab.filesystem.check;

import com.free4lab.filesystem.common.ConstantEnum;

/**
 * Created by Idan on 2017/7/21.
 */
public class UserCheck {

    private static UserCheck userCheck = new UserCheck();

    public static UserCheck getInstantce() {
        return userCheck;
    }


    //检查type
    public boolean checkRole(String role) {
//        if (role==null) {
//            return true;
//        }
//        switch (role) {
//            case ConstantEnum.USER_ROLE.ROLE_ADMIN:
//                return true;
//            case ConstantEnum.USER_ROLE.ROLE_USER:
//                return true;
//        }
//        return false;
        if (role == null) return true;
        if (role.equals(ConstantEnum.USER_ROLE.ROLE_ADMIN)) return true;
        else if (role.equals(ConstantEnum.USER_ROLE.ROLE_USER)) return true;
        else return false;
    }

}
