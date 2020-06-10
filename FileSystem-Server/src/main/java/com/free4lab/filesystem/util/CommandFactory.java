package com.free4lab.filesystem.util;

import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Constants;

/**
 * 用于产生linux shell命令的类
 * Created by lizhenhao on 2017/2/15.
 */
public class CommandFactory {

    /**
     * 读取某个目录然后获取目录中所有文件的命令（cd + ls -l）
     * @param path
     * @return
     */
    public static String[] cdCommand(String path) {
        String[] commands = new String[]{"/bin/sh","-c","cd "+ path+";ls -l"};
        return commands;

    }

    /**
     * 创建目录（mkdir name）
     * @param dirName
     * @return
     */
    public static String[] mkdirCommand(String path,String dirName) {
        String[] commands = new String[]{"/bin/sh","-c","cd "+path+";mkdir "+dirName};
        return commands;
    }

    /**
     * 删除文件(rm -rf name)
     * @param path
     * @param fileName
     * @return
     */
    public static String[] delCommand(String path,String fileName) {
        String[] commands = new String[]{"/bin/sh","-c","cd "+path+";rm -rf "+fileName};
        return commands;
    }

    /**
     * 重命令文件（mv name1 name2）
     * @param path
     * @param fileName
     * @return
     */
    public static String[] renameCommand(String path,String fileName,String newName) {
        String[] commands = new String[]{"/bin/sh","-c","cd "+path+";mv "+fileName+" "+newName};
        return commands;
    }

    /**
     * 查找文件并且显示出来
     * @param fileName
     * @return
     */
    public static String[] searchCommand(String fileName) {
        String[] commands = new String[]{"/bin/sh","-c","find "+Constants.ROOT_DIR
                +" -name "+fileName+" -exec ls -l -d {} \\;"};
        return commands;
    }
}
