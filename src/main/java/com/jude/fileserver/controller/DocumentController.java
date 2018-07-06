package com.jude.fileserver.controller;

import com.jude.fileserver.base.RoutingDataSourceContext;
import com.jude.fileserver.base.RoutingWith;
import com.jude.fileserver.bean.ResponseBean;
import com.jude.fileserver.bean.bo.DocumentBO;
import com.jude.fileserver.service.interf.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo_v1")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("document/{id}")
    public DocumentBO get(@PathVariable Long id){
        return documentService.getById(id);
    }

    @RequestMapping(value="document/{id}", method=RequestMethod.GET)
    @RoutingWith("slaveDataSource")
    public DocumentBO getDocument(@PathVariable Long id){
        return documentService.getById(id);
    }

    @RequestMapping(value="document", method = RequestMethod.POST)
    @RoutingWith("masterDataSource")
    public ResponseBean addDocument(@RequestBody DocumentBO documentBO){
        if(documentService.insert(documentBO.to())==1){
            return new ResponseBean("100","success",null);
        }else{
            return new ResponseBean("101","fail",null);
        }

    }
}
