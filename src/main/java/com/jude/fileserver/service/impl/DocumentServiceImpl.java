package com.jude.fileserver.service.impl;

import com.jude.fileserver.bean.bo.DocumentBO;
import com.jude.fileserver.bean.dao.DocumentDO;
import com.jude.fileserver.mapper.DocumentDOMapper;
import com.jude.fileserver.service.interf.DocumentService;
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
