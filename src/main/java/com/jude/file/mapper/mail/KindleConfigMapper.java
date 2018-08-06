package com.jude.file.mapper.mail;

import com.jude.file.bean.mail.dao.KindleConfig;

/**
 * @author jude
 */
public interface KindleConfigMapper {
    int insert(KindleConfig record);

    int insertSelective(KindleConfig record);

    KindleConfig selectByUserId(Long userId);
}