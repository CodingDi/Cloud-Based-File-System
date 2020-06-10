package com.free4lab.filesystem.search;

import com.free4lab.filesystem.sql.beans.FileDetailEntity;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by lizhenhao on 2017/6/14.
 */
public class SearchQueue {

    public static Queue<FileDetailEntity> linkedBlockingQueue = new LinkedBlockingQueue<FileDetailEntity>();

    static {
        new Thread(new SearchThread()).start();
    }

    public static void put(FileDetailEntity fileDetailEntity) {
        linkedBlockingQueue.add(fileDetailEntity);
    }

    public static FileDetailEntity get(){
        return linkedBlockingQueue.poll();
    }

}
