package com.jude.file.service.mail.impl;

import com.jude.file.bean.mail.dao.PushLogDO;
import com.jude.file.mapper.mail.PushLogMapper;
import com.jude.file.service.mail.interf.PushLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 15:23 2018/8/6
 * @description：pushLog
 */
@Service
public class PushLogServiceImpl implements PushLogService {

    @Autowired
    private PushLogMapper pushLogMapper;

    @Override
    public Boolean insert(PushLogDO pushLog) {
        return pushLogMapper.insert(pushLog) == 1;
    }

    @Override
    public List<PushLogDO> queryPage(Integer index, Integer size) {
        index = ((index-1) * size);
        return pushLogMapper.queryPage(index, size);
    }
}
