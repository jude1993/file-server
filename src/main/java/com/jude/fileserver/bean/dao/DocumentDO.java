package com.jude.fileserver.bean.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocumentDO {
    private Long id;

    private String fileName;

    private String path;


}