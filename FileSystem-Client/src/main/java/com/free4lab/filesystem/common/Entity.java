package com.free4lab.filesystem.common;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

/**
 * Created by lizhenhao on 2017/6/5.
 */
public class Entity<T> {

    private T entity;

    private String contentType;

    public Entity(T entity, String contentType) {
        this.entity = entity;
        this.contentType = contentType;
    }

    public static <T> Entity<T> form(T entity) {
        return new Entity<T>(entity, MediaType.APPLICATION_FORM_URLENCODED);
    }

    public static <T> Entity<T> text(T entity) {
        return new Entity<T>(entity, MediaType.TEXT_PLAIN);
    }

    public static <T> Entity<T> multiForm(T entity) {
        return new Entity<T>(entity,MediaType.MULTIPART_FORM_DATA);
    }

    public static <T> Entity<T> multiForm() {
        return new Entity<T>((T) new FormDataMultiPart(),MediaType.MULTIPART_FORM_DATA);
    }


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
