package com.free4lab.filesystem.clientconnector;

import com.free4lab.filesystem.beans.FileSystemResponse;
import com.free4lab.filesystem.beans.JerseyResponse;
import com.free4lab.filesystem.common.ClientFactory;
import com.free4lab.filesystem.request.FileSystemRequest;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/6/5.
 */
public class JerseyConnector implements Connector {

    protected Client client = ClientFactory.fileSystemClient;
    private static Logger logger = Logger.getLogger(JerseyConnector.class);

    public JerseyConnector() {}

    public <T> FileSystemResponse request(FileSystemRequest<T> request) {
        WebTarget target = client.target(request.getEndPoint()).path(request.getPath());

        for(Map.Entry<String, String> entry : request.getParams().entrySet()) {
            target = target.queryParam(entry.getKey(), entry.getValue());
        }

        Invocation.Builder invocation = target.request();

        for(Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            invocation.header(entry.getKey(), entry.getValue());
        }

        Entity<?> entity = (request.getEntity() == null) ? null :
                Entity.entity(request.getEntity().getEntity(), request.getEntity().getContentType());


        if (entity != null) {
            return new JerseyResponse(invocation.method(request.getMethod().name(), entity));
        } else {
            return new JerseyResponse(invocation.method(request.getMethod().name()));
        }

    }
}
