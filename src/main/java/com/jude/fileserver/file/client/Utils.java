package com.jude.fileserver.file.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Utils {
    /**
     * 获取传入路径文档信息
     * */
    public static Document getAllFile(String path){
        Document document = new Document();
        File file = new File(path);
        document.setName(file.getName());
        if(file.isDirectory()){
            List<Document> documents = new ArrayList<>();
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(f -> {
                documents.add(getAllFile(f.getPath()));
            });
            document.setChildFile(documents);
            document.setIsFile(false);
            return document;
        }
        document.setIsFile(true);
        return document;
    }

}
