package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.EnterpriseClient;
import com.free4lab.filesystem.client.LogoClient;
import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.*;
import com.free4lab.filesystem.util.ClientFactory;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.List;

/**
 * Created by lizhenhao on 2017/7/30.
 */
public class AdminAction extends BaseAction {

    private EnterpriseClient enterpriseClient = ClientFactory.getEnterpriceClient();
    private LogoClient logoClient = ClientFactory.getLogoClient();
    protected Logger logger = Logger.getLogger(AdminAction.class);

    private File file;
    private String fileFileName;
    private String type;
    private String id;
    private String errorCode;
    private String errorMessage;
    private String relativePath;
    private String absolutePath;
    private String enterpriseId;
    private String bannerLogoPath;
    private String innerLogoPath;
    private String landingLogoPath;
    private String bannerId;
    private String innerId;
    private String landingId;
    private String enterpriseName;
    private String enterpriseDescription;
    private String date;



    public String uploadLogo() {
        relativePath = Constants.RELATIVE_PATH + fileFileName;
        absolutePath = ServletActionContext.getServletContext().getRealPath("/") + "/" +relativePath;
        try {
            saveFile(file, absolutePath);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ERROR;
        }
        BasicResponse basicResponse = logoClient.Update().params("id",id!=null?id:"").params("relativePath",relativePath).params("absolutePath",absolutePath).params("type",type).params("name",fileFileName).params("enterpriseId",findEnterpriseId()).execute();
        errorCode = basicResponse.getErrorCode();
        errorMessage = basicResponse.getErrorMessage();
        return SUCCESS;
    }

    public String findAllLogoByEnterpriseId() {
        LogoResponse logoResponse = logoClient.Find().params("enterpriseId",findEnterpriseId()).execute();
        EnterpriseResponse enterpriseResponse = enterpriseClient.Find().execute();
        if (enterpriseResponse.getErrorCode().equals(Signal.OK)) {
            EnterpriseDetail enterpriseDetail = enterpriseResponse.getEnterpriseList().get(0);
            enterpriseName = enterpriseDetail.getName();
            enterpriseDescription = enterpriseDetail.getDescription();
            date = enterpriseDetail.getDate();
        }
        else {
            enterpriseName = "null";
            enterpriseDescription = "null";
            date = "null";
        }
        if(logoResponse.getErrorCode().equals(Signal.OK)) {
            List<LogoDetail>logoDetailList = logoResponse.getLogoList();
            for(LogoDetail logoDetail : logoDetailList) {
                if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.BANNER)) {
                    bannerId = String.valueOf(logoDetail.getId());
                    bannerLogoPath = logoDetail.getRelativePath();
                }
                else if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.LOGO_INNER)) {
                    innerId = String.valueOf(logoDetail.getId());
                    innerLogoPath = logoDetail.getRelativePath();
                }
                else if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.LOGO_LANDING)) {
                    landingId = String.valueOf(logoDetail.getId());
                    landingLogoPath = logoDetail.getRelativePath();
                }
            }
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }



    private void saveFile(File file, String path) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = new FileInputStream(file);
        outputStream = new FileOutputStream(path);
        int temp;
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(temp);
        }
        inputStream.close();
        outputStream.close();
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getBannerLogoPath() {
        return bannerLogoPath;
    }

    public void setBannerLogoPath(String bannerLogoPath) {
        this.bannerLogoPath = bannerLogoPath;
    }

    public String getInnerLogoPath() {
        return innerLogoPath;
    }

    public void setInnerLogoPath(String innerLogoPath) {
        this.innerLogoPath = innerLogoPath;
    }

    public String getLandingLogoPath() {
        return landingLogoPath;
    }

    public void setLandingLogoPath(String landingLogoPath) {
        this.landingLogoPath = landingLogoPath;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getInnerId() {
        return innerId;
    }

    public void setInnerId(String innerId) {
        this.innerId = innerId;
    }

    public String getLandingId() {
        return landingId;
    }

    public void setLandingId(String landingId) {
        this.landingId = landingId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseDescription() {
        return enterpriseDescription;
    }

    public void setEnterpriseDescription(String enterpriseDescription) {
        this.enterpriseDescription = enterpriseDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
