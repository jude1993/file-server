package com.jude.file.service.mail.impl;

import com.jude.file.bean.mail.dao.OperationLog;
import com.jude.file.common.PageCondition;
import com.jude.file.mapper.mail.OperationLogMapper;
import com.jude.file.service.mail.interf.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：wupeng
 * @date ：Created in 17:03 2018/8/10
 * @description：
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public void insert(OperationLog operationLogDO) {
        operationLogMapper.insert(operationLogDO);
    }

    @Override
    public List<OperationLog> queryPage(PageCondition pageCondition) {
        return operationLogMapper.queryPage(pageCondition);
    }
}
