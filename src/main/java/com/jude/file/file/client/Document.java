package com.jude.file.file.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@ToString
/**
 * 文档信息
 * */
public class Document {
    /**
     * 该文件夹下所有文件，如果不是文件夹则为null
     * */
    private List<Document> childFile;
    /**
     * 文档名
     * */
    private String name;
    /**
     * 是否是文件
     * */
    private Boolean isFile;
    /**
     * 路径
     * */
    private String path;

    public Document(){}

    public Document(File file){
        if(file.isDirectory()){
            this.childFile = Stream.of(Objects.requireNonNull(file.listFiles()))
                    .map(Document::new)
                    .collect(Collectors.toList());
        }
        this.name = file.getName();
        this.isFile = file.isFile();
        this.path = file.getPath();
    }


    public Document(File[] files, String name,Boolean isFile, String path){
        if(files != null){
            this.childFile =
                    Stream.of(files)
                            .map(f -> new Document(null,f.getName(),f.isFile(),f.getPath()))
                            .collect(Collectors.toList());
        }
        this.name = name;
        this.isFile = isFile;
        this.path = path;
    }
}
