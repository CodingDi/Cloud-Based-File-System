package com.free4lab.filesystem.request;

import com.free4lab.filesystem.client.FileSystemClient;
import com.free4lab.filesystem.common.Entity;
import com.free4lab.filesystem.common.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/6/5.
 */
public class FileSystemRequest<T> {

    private FileSystemClient client;

    private String endPoint;

    private StringBuilder path = new StringBuilder();

    private Map<String,String> headers = new HashMap<String, String>();

    private Map<String,String> params = new HashMap<String, String>();

    private Class<T> returnType;

    private HttpMethod method;

    private Entity<?> entity;

    public FileSystemRequest(FileSystemClient client, String endPoint, String path,Class returnType,HttpMethod method,Entity entity) {
        this.client = client;
        this.endPoint = endPoint;
        this.path = new StringBuilder(path);
        this.returnType = returnType;
        this.method = method;
        this.entity = entity;
    }

    public <T> T execute() {
        return (T) client.request(this);
    }

    public FileSystemRequest<T> headers(String key, String value) {
        headers.put(key,value);
        return this;
    }
    public FileSystemRequest<T> params(String key, String value) {
        params.put(key,value);
        return this;
    }

    public FileSystemRequest<T> path(String path) {
        if(!path.startsWith("\\/")) {
            this.path.append("/");
        }
        this.path.append(path);
        return this;
    }


    public FileSystemClient getClient() {
        return client;
    }

    public void setClient(FileSystemClient client) {
        this.client = client;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPath() {
        return path.toString();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Class<T> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<T> returnType) {
        this.returnType = returnType;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Entity<?> getEntity() {
        return entity;
    }

    public void setEntity(Entity<?> entity) {
        this.entity = entity;
    }
}
