package com.jude.file.mapper.file;

import com.jude.file.bean.file.dao.DocumentDO;

public interface DocumentDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DocumentDO record);

    int insertSelective(DocumentDO record);

    DocumentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DocumentDO record);

    int updateByPrimaryKey(DocumentDO record);
}