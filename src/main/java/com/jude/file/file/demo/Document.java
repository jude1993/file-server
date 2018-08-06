package com.jude.file.file.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Document {
    private List<Document> fileList;
    private String name;
    private Boolean isFile;

}
