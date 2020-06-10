package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.Constants;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.io.File;
import java.net.URL;
import java.util.Map;

/**
 * Created by lizhenhao on 2017/2/18.
 */
public abstract class AbstractClient<T> {

    protected Logger logger = Logger.getLogger(AbstractClient.class);

    private WebTarget webTarget;

    public AbstractClient() {
        this(Constants.BASE_URI);
    }
    public AbstractClient(String uri) {
        Configurable configurable = new ClientConfig();
        Client client = ClientBuilder.newClient((Configuration) configurable);
        webTarget = client.target(Constants.BASE_URI);
    }

    protected abstract Class<?> getType();


    /**
     * get方法或者delete方法(queryparam)
     * @return
     */
    protected T getOrDel(String requestPath, Map<String,Object> map,int method) {
        WebTarget target = webTarget.path(requestPath);
        for (Map.Entry<String, Object> param : map.entrySet()) {
            logger.info("请求参数为：key= " + param.getKey() + " and value= " + param.getValue());
            target = target.queryParam(param.getKey(),param.getValue());
        }
        switch (method) {
            case Constants.GET:
                return (T) target.request(MediaType.APPLICATION_XML).get(getType());
            case Constants.DELETE:
                return (T) target.request(MediaType.APPLICATION_XML).delete(getType());
            default:
                return null;
        }
    }

    /**
     * post方法或者PUT方法(formparam)
     * @param requestPath
     * @param map
     * @return
     */
    protected T postOrPut(String requestPath,Map<String,String> map,int method) {
        WebTarget target = webTarget.path(requestPath);
        Form form = new Form();
        for (Map.Entry<String, String> param : map.entrySet()) {
            logger.info("请求参数为：key= " + param.getKey() + " and value= " + param.getValue());
            form.param(param.getKey(), param.getValue());
        }
        switch (method) {
            case Constants.POST:
                return (T) target.request(MediaType.APPLICATION_XML).
                        post(Entity.form(form), getType());
            case Constants.PUT:
                return (T) target.request(MediaType.APPLICATION_XML).
                        put(Entity.form(form), getType());
            default:
                return null;
        }
    }

    /**
     * post方法，传输文件
     */
    protected T post(File file, String requestPath) {
        WebTarget target = webTarget.path(requestPath);
        Entity<File> resource = Entity.entity(file,MediaType.TEXT_PLAIN);
        return (T) target.request(MediaType.APPLICATION_XML).post(resource,getType());
    }


    /**
     * get方法
     * @return beans
     */
    protected Response get(String requestPath, Map<String,Object> map) {
        WebTarget target = webTarget.path(requestPath);
        for (Map.Entry<String, Object> param : map.entrySet()) {
            logger.info("请求参数为：key= " + param.getKey() + " and value= " + param.getValue());
            target = target.queryParam(param.getKey(),param.getValue());
        }
        return target.request(MediaType.APPLICATION_XML).get();
    }










    //---------------------------test--------------------------

    public void testType() {
        URL url = getClass().getClassLoader().getResource("struts.xml");
        File file = new File(url.getFile());
        String contentType = new MimetypesFileTypeMap().getContentType(file);
        System.out.println(contentType);
    }




    public static void main(String args[]) {
        Client client = ClientBuilder.newClient();
        Client client2 = ClientBuilder.newClient();

        WebTarget webTarget = client.target(Constants.BASE_URI);
        WebTarget pathTarget = webTarget.path("fileDownLoad");
//        Form form = new Form();
//        form.param("fileName", "bb");
//        form.param("path", "aa");
        WebTarget paramTarget = pathTarget.queryParam("fileName", "aa").queryParam("path", "pp");
        Response response = paramTarget.request(MediaType.APPLICATION_XML)
                .get();

        long content = Long.parseLong(response.getHeaderString("FileLength"));
        System.out.println(content);


    }


//        fileOpClient.fileUpLoad("aa","/nn/ggg/gg");
}


