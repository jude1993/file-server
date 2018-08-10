package com.jude.file.service.mail.interf;

import com.jude.file.bean.mail.dao.OperationLog;
import com.jude.file.common.PageCondition;

import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 17:02 2018/8/10
 * @description：
 */
public interface OperationLogService {

    /**
     * 插入一条操作记录
     * @param operationLogDO 操作实体
     * */
    void insert(OperationLog operationLogDO);

    /**
     * 分页获取记录
     * @param pageCondition 查询条件
     * @return
     * */
    List<OperationLog> queryPage(PageCondition pageCondition);
}
