package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.sql.beans.DirDetailEntity;
import com.free4lab.filesystem.sql.dao.DirDetailDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lizhenhao on 2017/2/27.
 */
public class DirTreeService {
    private static DirTreeService dirTreeManager = new DirTreeService();

    public static DirTreeService getInstance() {
        return dirTreeManager;
    }

    private static DirDetailDao dirTreeContentDao = new DirDetailDao();

    /**
     * 过滤所有文件，只留下文件夹
     * @return
     */
    public List<DirDetailEntity> findAllDirectory() {
        List<DirDetailEntity> list = new ArrayList<DirDetailEntity>();
        list = dirTreeContentDao.findAll();
        Iterator<DirDetailEntity> iterator = list.iterator();
        while(iterator.hasNext()){
            DirDetailEntity dirTreeContent = iterator.next();
            if(!dirTreeContent.getType().equals("d")) {
                iterator.remove();
            }
        }
        return list;
    }

    /**
     * 找出指定ID下的文件
     * @param id
     * @return
     */
    public  List<DirDetailEntity> findPathFile(Integer id) {
        List<DirDetailEntity> list = new ArrayList<DirDetailEntity>();
        list = dirTreeContentDao.findByProperty("pId",id);
        Iterator<DirDetailEntity> iterator = list.iterator();
        while(iterator.hasNext()){
            DirDetailEntity dirTreeContent = iterator.next();
            if(dirTreeContent.getType().equals("d")) {
                iterator.remove();
            }
        }
        return list;
    }

    /**
     * 找出指定PID和name文件
     */
    public DirDetailEntity findFile(Integer id, String fileName) {
        List<DirDetailEntity> list = new ArrayList<DirDetailEntity>();
        DirDetailEntity dirTreeContent = new DirDetailEntity();
        list = dirTreeContentDao.findByProperty2("pId",id,"name",fileName);
        if(list.size() >0) {
            dirTreeContent = list.get(0);
        }
        return dirTreeContent;
    }

    public void deleteFile(Integer id) {
        dirTreeContentDao.deleteByPrimaryKey(id);
    }

    public DirDetailEntity updateFile(DirDetailEntity dirTreeContent) {
        return dirTreeContentDao.update(dirTreeContent);
    }

    public void saveFile(DirDetailEntity dirTreeContent) {
        dirTreeContentDao.save(dirTreeContent);
    }
}
