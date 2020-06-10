package com.free4lab.filesystem.beans;

import com.free4lab.filesystem.exception.FileSystemResponseException;

import javax.ws.rs.core.Response;

/**
 * Created by lizhenhao on 2017/6/6.
 */
public class JerseyResponse implements FileSystemResponse {

    private Response response;

    public JerseyResponse(Response response) {
        this.response = response;
    }


    public <T> T getEntity(Class<T> returnType) throws FileSystemResponseException {
        if(response.getStatus() >= 400) {
            throw new FileSystemResponseException(response.getStatusInfo().getReasonPhrase(),
                    response.getStatusInfo().getStatusCode());
        }
        return response.readEntity(returnType);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
