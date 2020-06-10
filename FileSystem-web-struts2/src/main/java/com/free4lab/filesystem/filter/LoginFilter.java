package com.free4lab.filesystem.filter;

import com.free4lab.filesystem.client.LogoClient;
import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.LogoDetail;
import com.free4lab.filesystem.response.LogoResponse;
import com.free4lab.filesystem.util.ClientFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class LoginFilter implements Filter{
    private LogoClient logoClient = ClientFactory.getLogoClient();

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("userId") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            findAllLogoByEnterpriseId(request.getParameter("enterpriseId"));
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login/landing?bannerLogoPath="+bannerLogoPath + "&innerLogoPath=" + innerLogoPath+"&landingLogoPath=" + landingLogoPath);
        }
    }
    public void destroy() {

    }

    private String bannerLogoPath;
    private String innerLogoPath;
    private String landingLogoPath;

    //查询数据库，动态改变logo
    private void findAllLogoByEnterpriseId(String enterpriseId) {
        if (enterpriseId == null) {
            bannerLogoPath = null;
            innerLogoPath = null;
            landingLogoPath = null;
            return;
        }
        LogoResponse logoResponse = logoClient.Find().params("enterpriseId",enterpriseId).execute();
        if(logoResponse.getErrorCode().equals(Signal.OK)) {
            List<LogoDetail> logoDetailList = logoResponse.getLogoList();
            for(LogoDetail logoDetail : logoDetailList) {
                if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.BANNER)) {
                    bannerLogoPath = logoDetail.getRelativePath();
                }
                else if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.LOGO_INNER)) {
                    innerLogoPath = logoDetail.getRelativePath();
                }
                else if(logoDetail.getType().equals(ConstantEnum.LOGO_TYPE.LOGO_LANDING)) {
                    landingLogoPath = logoDetail.getRelativePath();
                }
            }
        }
    }
}
