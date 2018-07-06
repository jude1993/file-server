package com.jude.fileserver.service.interf;


import com.jude.fileserver.bean.bo.DocumentBO;
import com.jude.fileserver.bean.dao.DocumentDO;

/**
 * @author jude
 */
public interface DocumentService {

    DocumentBO getById(Long id);

    int insert(DocumentDO documentDO);
}
