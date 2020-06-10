package com.free4lab.filesystem.operate;

import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.UserResponse;
import com.free4lab.filesystem.sql.beans.UserEntity;

/**
 * Created by lizhenhao on 2017/7/18.
 */
public interface UserOperate {

    //查询
    public UserResponse findUser(String tel, String password);

    public UserResponse findByRoleAnEnterpriseId(String role,String enterpriseId);

    public UserResponse findUserByRole(String role);
    //增加
    public BasicResponse saveUser(String userName,String role,String enterpriseId,String tel, String password);

    //修改
    public BasicResponse updateUser(String userId,String userName,String role, String tel, String password);

    //修改密码
    public BasicResponse modifyPassword(String userId, String oldPassword, String newPassword);

    //删除
    public BasicResponse deleteUser(String userId);
}
