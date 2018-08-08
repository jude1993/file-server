package com.jude.file.mapper.mail;

import com.jude.file.bean.mail.dao.KindleConfigDO;

/**
 * @author jude
 */
public interface KindleConfigMapper {
    int insert(KindleConfigDO record);

    int insertSelective(KindleConfigDO record);

    KindleConfigDO selectByUserId(Long userId);
}