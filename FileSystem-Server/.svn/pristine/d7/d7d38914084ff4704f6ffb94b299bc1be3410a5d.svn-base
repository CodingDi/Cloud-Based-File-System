package com.free4lab.filesystem.operate.imp;

import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.EnterpriseOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.EnterpriseDetail;
import com.free4lab.filesystem.response.EnterpriseResponse;
import com.free4lab.filesystem.sql.beans.EnterpriseEntity;
import com.free4lab.filesystem.sql.service.EnterpriseService;
import com.free4lab.filesystem.util.EntityUtil;
import com.free4lab.filesystem.util.StringUtil;
import com.free4lab.filesystem.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan on 2017/7/26.
 */
@Component
public class EnterpriseOperateImpl implements EnterpriseOperate {

//    @Autowired
    private EnterpriseService enterpriseService = EnterpriseService.getInstance();

    @Override
    public BasicResponse save(String name, String description) {
        if (enterpriseService.findByName(name) || name==null) {
            return new BasicResponse(Signal.SAVE_ENTERPRISE_ERROR,Signal.STATUS_DUPLICATEUSER_ERROR);
        }
        EnterpriseEntity entity = new EnterpriseEntity(name,description);
        entity.setCreateDate(TimeUtil.getCurrentTimestamp());
        enterpriseService.save(entity);
        return new BasicResponse(Signal.SUCCESS,Signal.OK);
    }

    @Override
    public BasicResponse delete(String enterpriseId) {
        if (enterpriseId == null) {
            return new BasicResponse(Signal.DELETE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
        try {
            boolean rs =  enterpriseService.deleteById(Integer.valueOf(enterpriseId));
            if (rs) {
                return new BasicResponse(Signal.SUCCESS,Signal.OK);
            } {
                return new BasicResponse(Signal.DELETE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(Signal.DELETE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
    }

    @Override
    public BasicResponse update(String enterpriseId, String name, String description) {
        if (enterpriseId == null) {
            return new BasicResponse(Signal.UPDATE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
        try {
            EnterpriseEntity enterpriseEntity = enterpriseService.findById(Integer.valueOf(enterpriseId));
            if (enterpriseEntity == null) {
                return new BasicResponse(Signal.UPDATE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
            }
            if (!StringUtil.isNullOrEmpty(name)) {
                enterpriseEntity.setName(name);
            }
            if (!StringUtil.isNullOrEmpty(description)) {
                enterpriseEntity.setDescription(description);
            }
            EnterpriseEntity result = enterpriseService.update(enterpriseEntity);
            if (result==null) {
                return new BasicResponse(Signal.UPDATE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
            } else {
                return new BasicResponse(Signal.SUCCESS,Signal.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(Signal.UPDATE_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }
    }

    @Override
    public EnterpriseResponse find(String enterpriseId) {
        List<EnterpriseDetail> result = new ArrayList<EnterpriseDetail>();
        if (!StringUtil.isNullOrEmpty(enterpriseId)) {
            EnterpriseEntity entity = enterpriseService.findById(Integer.valueOf(enterpriseId));
            EnterpriseDetail temp = new EnterpriseDetail();
            EntityUtil.converJavaBean(temp,entity);
            temp.setDate(TimeUtil.ConverToString(entity.getCreateDate()));
            result.add(temp);
        }
        else {
            result = enterpriseService.getAllEnterprise();
        }
        if (result!=null) {
            return new EnterpriseResponse(result, Signal.SUCCESS,Signal.OK);
        } else {
            return new EnterpriseResponse(Signal.FIND_ENTERPRISE_ERROR,Signal.STATUS_INVALID_PARAMETER);
        }

    }
}
