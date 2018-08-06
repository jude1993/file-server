package com.jude.file.service.file.impl;

import com.jude.file.bean.file.bo.DocumentBO;
import com.jude.file.bean.file.dao.DocumentDO;
import com.jude.file.service.file.interf.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDOMapper documentDOMapper;
    @Override
    public DocumentBO getById(Long id) {
        return DocumentBO.from(documentDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public int insert(DocumentDO documentDO) {
        return documentDOMapper.insert(documentDO);
    }
}
