package com.free4lab.filesystem.sql.service;

import com.free4lab.filesystem.sql.beans.DirTreeContent;
import com.free4lab.filesystem.sql.dao.DirTreeContentDao;

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

    private static DirTreeContentDao dirTreeContentDao = new DirTreeContentDao();

    /**
     * 过滤所有文件，只留下文件夹
     * @return
     */
    public List<DirTreeContent> findAllDirectory() {
        List<DirTreeContent> list = new ArrayList<DirTreeContent>();
        list = dirTreeContentDao.findAll();
        Iterator<DirTreeContent> iterator = list.iterator();
        while(iterator.hasNext()){
            DirTreeContent dirTreeContent = iterator.next();
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
    public  List<DirTreeContent> findPathFile(Integer id) {
        List<DirTreeContent> list = new ArrayList<DirTreeContent>();
        list = dirTreeContentDao.findByProperty("pId",id);
        Iterator<DirTreeContent> iterator = list.iterator();
        while(iterator.hasNext()){
            DirTreeContent dirTreeContent = iterator.next();
            if(dirTreeContent.getType().equals("d")) {
                iterator.remove();
            }
        }
        return list;
    }

    /**
     * 找出指定PID和name文件
     */
    public DirTreeContent findFile(Integer id,String fileName) {
        List<DirTreeContent> list = new ArrayList<DirTreeContent>();
        DirTreeContent dirTreeContent = new DirTreeContent();
        list = dirTreeContentDao.findByProperty2("pId",id,"name",fileName);
        if(list.size() >0) {
            dirTreeContent = list.get(0);
        }
        return dirTreeContent;
    }

    public void deleteFile(Integer id) {
        dirTreeContentDao.deleteByPrimaryKey(id);
    }

    public DirTreeContent updateFile(DirTreeContent dirTreeContent) {
        return dirTreeContentDao.update(dirTreeContent);
    }

    public void saveFile(DirTreeContent dirTreeContent) {
        dirTreeContentDao.save(dirTreeContent);
    }
}
