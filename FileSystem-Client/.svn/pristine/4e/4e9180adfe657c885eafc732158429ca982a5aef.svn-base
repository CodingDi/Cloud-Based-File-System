package com.free4lab.filesystem.client;

import com.free4lab.filesystem.common.HttpMethod;
import com.free4lab.filesystem.request.FileSystemRequest;
import com.free4lab.filesystem.response.SearchResponse;

/**
 * Created by lizhenhao on 2017/6/14.
 */
public class FileSearchClient {

    private FileSystemClient CLIENT;

    public FileSearchClient(String endpoint) {
        CLIENT = new FileSystemClient(endpoint);
    }

    public Find Find() {
        return new Find();
    }

    public Search Search() {
        return new Search();
    }

    public class Find extends FileSystemRequest<SearchResponse> {
        public Find() {
            super(CLIENT,null,"/fileResource/fileFind",SearchResponse.class, HttpMethod.GET,null);
        }
    }

    public class Search extends FileSystemRequest<SearchResponse> {
        public Search() {
            super(CLIENT,null,"/fileResource/fileSearch",SearchResponse.class,HttpMethod.GET,null);
        }
    }



}
