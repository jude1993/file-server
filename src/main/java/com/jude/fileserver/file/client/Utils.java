package com.jude.fileserver.file.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
