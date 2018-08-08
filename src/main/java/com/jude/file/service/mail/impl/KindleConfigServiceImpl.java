package com.jude.file.service.mail.impl;

import com.jude.file.bean.mail.dao.KindleConfigDO;
import com.jude.file.mapper.mail.KindleConfigMapper;
import com.jude.file.service.mail.KindleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：wupeng
 * @date ：Created in 16:25 2018/8/8
 * @description：kindle邮箱配置
 */
@Service
public class KindleConfigServiceImpl implements KindleConfigService {
    @Autowired
    private KindleConfigMapper kindleConfigMapper;

    @Override
    public boolean config(KindleConfigDO kindleConfigDO) {
        return kindleConfigMapper.insert(kindleConfigDO) == 1;
    }

    @Override
    public KindleConfigDO selectByUserId(Long userId) {
        KindleConfigDO kindleConfigDO = kindleConfigMapper.selectByUserId(userId);
        if(kindleConfigDO == null){
            KindleConfigDO kindleConfig = KindleConfigDO.init(userId);
            kindleConfigMapper.insert(kindleConfig);
            return kindleConfig;
        }
        return kindleConfigDO;
    }


}
