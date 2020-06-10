package com.free4lab.filesystem.operate.imp;

import com.free4lab.filesystem.check.DirCheck;
import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.DirectoryOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.DirDetail;
import com.free4lab.filesystem.response.DirectoryResponse;
import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.service.DirDetailService;
import com.free4lab.filesystem.util.StringUtil;
import com.free4lab.filesystem.util.TimeUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Idan on 2017/6/12.
 */
@Component
public class DirectoryOperateImp implements DirectoryOperate {

    private static Logger logger = Logger.getLogger(DirectoryOperateImp.class);

    private DirDetailService dirDetailService = DirDetailService.getInstance();

    private DirCheck dirCheck = DirCheck.getInstantce();

    //获得数据库的数据
    //三种顺序
    //1.年度->部门->事件
    //2.部门->年度->事件
    //3.事件->部门->年度
    public DirectoryResponse getDirectory(String kind,String type,String enterpriseId) {
        Map<String,DirDetail> queryMap = ConstantEnum.dirTypeList.get(Integer.valueOf(kind));
        if (StringUtil.isNullOrEmpty(type) && !dirCheck.checkType(type)) {
            return new DirectoryResponse(Signal.GET_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }

        DirDetail dirDetail = queryMap.get(type); //拿到类型和是否是父节点
        String dirQueryType = dirDetail.getType();
        Boolean isParent = dirDetail.getIsParent();

        List<DirDetail> result = dirDetailService.getByType(dirQueryType,enterpriseId);
        if (result==null) {
            return new DirectoryResponse(Signal.GET_DIR_ERROR,Signal.STATUS_DATABASE_ERROR);
        } else {
            for (int i=0;i<result.size();i++) {
                result.get(i).setIsParent(isParent);
            }
            return new DirectoryResponse(result,null,Signal.OK);
        }
    }

    public DirectoryResponse getDirectory(String type,String enterpriseId) {
        List<DirDetail> result = dirDetailService.getByType(type,enterpriseId);
        if (result==null) {
            return new DirectoryResponse(Signal.GET_DIR_ERROR,Signal.STATUS_DATABASE_ERROR);
        } else {
            return new DirectoryResponse(result,Signal.SUCCESS,Signal.OK);
        }
    }

        //添加文件夹,名字判重
    public BasicResponse createDirectory(String type, String dirName,String enterpriseId) {
        List<DirDetailEntity> temp = dirDetailService.getByParam(null,dirName,null);
        if (temp.size()!=0) {
            return new BasicResponse(Signal.STATUS_EXISTED,"the directory is exited");
        } else {
            DirDetailEntity entity = new DirDetailEntity(dirName,type,enterpriseId);
            entity.setCreateDate(TimeUtil.getCurrentTimestamp());
            DirDetailEntity result = dirDetailService.save(entity);
            if (result==null) {
                return new BasicResponse(Signal.STATUS_INVALID_PARAMETER,Signal.STATUS_DATABASE_ERROR);
            } else {
                return new BasicResponse(Signal.SUCCESS,Signal.OK);
            }
        }
    }

    @Override
    public BasicResponse updateDirectory(String dirId, String name,String type) {
        if (dirId==null) {
            return new BasicResponse(Signal.DELETE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
        try {
            DirDetailEntity dirEntity = dirDetailService.getById(Integer.valueOf(dirId));
            if (dirEntity==null) {
                return new BasicResponse(Signal.UPDATE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
            }
            if (!StringUtil.isNullOrEmpty(name)) {
                dirEntity.setName(name);
            }
            if (!StringUtil.isNullOrEmpty(type)) {
                dirEntity.setType(type);
            }
            DirDetailEntity result = dirDetailService.update(dirEntity);
            if (result==null) {
                return new BasicResponse(Signal.UPDATE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
            } else {
                return new BasicResponse(Signal.SUCCESS,Signal.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(Signal.UPDATE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
    }

    @Override
    public BasicResponse deleteDirectory(String dirId) {
        if (dirId==null) {
            return new BasicResponse(Signal.DELETE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
        try {
            boolean rs = dirDetailService.deteleById(Integer.valueOf(dirId));
            if (rs) {
                return new BasicResponse(Signal.SUCCESS,Signal.OK);
            } else {
                return new BasicResponse(Signal.DELETE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(Signal.DELETE_DIR_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
    }
}
