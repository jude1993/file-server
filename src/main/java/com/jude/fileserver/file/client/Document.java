package com.jude.fileserver.file.client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

}
