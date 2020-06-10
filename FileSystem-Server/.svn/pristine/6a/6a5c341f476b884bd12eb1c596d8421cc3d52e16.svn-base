package com.free4lab.filesystem.operate.imp;

import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.operate.LogoOperate;
import com.free4lab.filesystem.response.BasicResponse;
import com.free4lab.filesystem.response.LogoDetail;
import com.free4lab.filesystem.response.LogoResponse;
import com.free4lab.filesystem.sql.beans.LogoEntity;
import com.free4lab.filesystem.sql.service.LogoService;
import com.free4lab.filesystem.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lizhenhao on 2017/7/30.
 */
@Component
public class LogoOperateImp implements LogoOperate{

    private LogoService logoService = LogoService.getInstance();

    @Override
    public LogoResponse save(String name, String type, String relativePath, String absolutePath, String relativePathServer, String absolutePathServer, String enterpriseId) {
        return null;
    }

    @Override
    public BasicResponse upadte(String id,String name, String type, String relativePath, String absolutePath, String relativePathServer, String absolutePathServer, String enterpriseId) {
        if(StringUtil.isNullOrEmpty(enterpriseId)) return new BasicResponse(Signal.UPDATE_LOGO_ERROR,Signal.STATUS_INVALID_PARAMETER);
        LogoEntity logoEntity;
        if(!StringUtil.isNullOrEmpty(id)) {
            logoEntity = logoService.getLogoById(id);
        }
        else {
            logoEntity = new LogoEntity();
        }
        logoEntity.setName(name);
        logoEntity.setType(type);
        logoEntity.setRelativePath(relativePath);
        logoEntity.setAbsolutePath(absolutePath);
        // TODO: 2017/7/30 服务器端的路径是存在server端服务器，还是前端服务器
        logoEntity.setEnterpriseId(enterpriseId);
        if(logoService.update(logoEntity) == null) return new BasicResponse(Signal.UPDATE_LOGO_ERROR,Signal.STATUS_DATABASE_ERROR);
        return new BasicResponse(Signal.SUCCESS,Signal.OK);
    }

    @Override
    public LogoResponse find(String enterpriseId) {
        if(StringUtil.isNullOrEmpty(enterpriseId)) return new LogoResponse(Signal.FIND_LOGO_ERROR,Signal.STATUS_INVALID_PARAMETER);
        List<LogoDetail> list = logoService.getAllLogoByInterpriseId(enterpriseId);
        if(list == null) return new LogoResponse(Signal.FIND_LOGO_ERROR,Signal.STATUS_DATABASE_ERROR);
        return new LogoResponse(list,Signal.SUCCESS,Signal.OK);
    }
}
