package com.jude.file.mapper.mail;

import com.jude.file.bean.mail.dao.OperationLog;
import com.jude.file.common.PageCondition;

import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 16:53 2018/8/10
 * @description：
 */
public interface OperationLogMapper {
    /**
     * 插入一条操作记录
     * @param operationLogDO 操作bean
     * @return
     * */
    int insert(OperationLog operationLogDO);

    /**
     * 分页查询
     * @param pageCondition
     * @return list
     * */
    List<OperationLog> queryPage(PageCondition pageCondition);


}
