package com.jude.file.service.mail;

import com.jude.file.bean.mail.dao.KindleConfigDO;

/**
 * @author ：wupeng
 * @date ：Created in 16:23 2018/8/8
 * @description：配置kindle邮箱
 */
public interface KindleConfigService {
    /**
     * @param kindleConfigDO bean
     * @return boolean true 成功 false 失败
     * */
    boolean config(KindleConfigDO kindleConfigDO);

    /**
     * @param userId userId
     * @return boolean true 成功 false 失败
     * */
    KindleConfigDO selectByUserId(Long userId);


}
