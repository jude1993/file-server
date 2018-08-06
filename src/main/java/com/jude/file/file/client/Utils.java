package com.jude.file.file.client;

import java.io.File;

public class Utils {
    /**
     * 获取传入路径文档信息
     * */
    public static Document getAllFile(String path){
        return new Document(new File(path));
    }

    /**
     *
     * */
    public static Document getChildFiles(String path){
        File file = new File(path);
        return new Document(file.listFiles(),file.getName(),file.isFile(),file.getPath());
    }

}
