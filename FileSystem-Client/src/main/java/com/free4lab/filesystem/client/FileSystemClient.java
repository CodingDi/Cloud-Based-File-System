package com.free4lab.filesystem.client;

import com.free4lab.filesystem.clientconnector.JerseyConnector;
import com.free4lab.filesystem.exception.FileSystemResponseException;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.beans.FileSystemResponse;

/**
 * Created by lizhenhao on 2017/6/5.
 */
public class FileSystemClient {

    private JerseyConnector jerseyConnector;

    private String endpoint;

    public FileSystemClient(String endpoint) {
        this.endpoint = endpoint;
        jerseyConnector = new JerseyConnector();
    }

    public <T> T request(FileSystemRequest<T> request) {
        request.setEndPoint(endpoint);
        FileSystemResponse fileSystemResponse = jerseyConnector.request(request);
        try {
            if(request.getReturnType() == null) return (T) fileSystemResponse;
            else return fileSystemResponse.getEntity(request.getReturnType());
        } catch (FileSystemResponseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
