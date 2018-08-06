package com.jude.file.service.file.interf;


import com.jude.file.bean.file.bo.DocumentBO;
import com.jude.file.bean.file.dao.DocumentDO;

/**
 * @author jude
 */
public interface DocumentService {

    DocumentBO getById(Long id);

    int insert(DocumentDO documentDO);
}
