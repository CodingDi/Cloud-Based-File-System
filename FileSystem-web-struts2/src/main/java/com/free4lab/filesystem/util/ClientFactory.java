package com.free4lab.filesystem.util;

import com.free4lab.filesystem.client.*;
import com.free4lab.filesystem.common.Constants;

/**
 * Created by lizhenhao on 2017/7/3.
 */
public class ClientFactory {

    private static DirectoryClient directoryClient = null;
    private static FileOperatorClient fileOperatorClient  = null;
    private static FileSearchClient fileSearchClient = null;
    private static UserClient userClient = null;
    private static EnterpriseClient enterpriseClient = null;
    private static LogoClient LogoClient = null;


    public ClientFactory() {}

    public static DirectoryClient getDirectoryClient() {
        if (directoryClient == null) {
            synchronized (ClientFactory.class) {
                if (directoryClient == null) {
                    directoryClient = new DirectoryClient(Constants.BASE_URI);
                }
            }
        }
        return directoryClient;
    }

    public static FileOperatorClient getFileOperatorClient() {
        if (fileOperatorClient == null) {
            synchronized (ClientFactory.class) {
                if (fileOperatorClient == null) {
                    fileOperatorClient = new FileOperatorClient(Constants.BASE_URI);
                }
            }
        }
        return fileOperatorClient;
    }

    public static FileSearchClient getFileSearchClient() {
        if (fileSearchClient == null) {
            synchronized (ClientFactory.class) {
                if (fileSearchClient == null) {
                    fileSearchClient = new FileSearchClient(Constants.BASE_URI);
                }
            }
        }
        return fileSearchClient;
    }

    public static UserClient getUserClient() {
        if (userClient == null) {
            synchronized (ClientFactory.class) {
                if (userClient == null) {
                    userClient = new UserClient(Constants.BASE_URI);
                }
            }
        }
        return userClient;
    }

    public static EnterpriseClient getEnterpriceClient() {
        if (enterpriseClient == null) {
            synchronized (ClientFactory.class) {
                if (enterpriseClient == null) {
                    enterpriseClient = new EnterpriseClient(Constants.BASE_URI);
                }
            }
        }
        return enterpriseClient;
    }

    public static LogoClient getLogoClient() {
        if (LogoClient == null) {
            synchronized (ClientFactory.class) {
                if (LogoClient == null) {
                    LogoClient = new LogoClient(Constants.BASE_URI);
                }
            }
        }
        return LogoClient;
    }

}
