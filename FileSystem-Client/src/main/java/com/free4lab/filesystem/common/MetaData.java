package com.free4lab.filesystem.common;

import java.util.Map;

/**
 * Created by lizhenhao on 2017/6/5.
 */
public class MetaData {

    private Map<String,Object> map;

    public MetaData(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
