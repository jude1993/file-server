package com.jude.fileserver.controller;

import com.jude.fileserver.bean.bo.DocumentBO;
import com.jude.fileserver.service.interf.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo_v1")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("document/{id}")
    public DocumentBO get(@PathVariable Long id){
        return documentService.getById(id);
    }
}
