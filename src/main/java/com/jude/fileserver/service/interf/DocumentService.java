package com.jude.fileserver.service.interf;


import com.jude.fileserver.bean.bo.DocumentBO;

public interface DocumentService {

    DocumentBO getById(Long id);
}
