package com.free4lab.filesystem.common;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by lizhenhao on 2017/6/14.
 */
public class ClientFactory {

    public static Client fileSystemClient;

    static {
        init();
    }

    private static void init() {
//        Configurable configurable = new ClientConfig();
//        configurable = configurable.register(MultiPartFeature.class);
//        fileSystemClient = ClientBuilder.newClient((Configuration) configurable);
        fileSystemClient = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
    }
}
