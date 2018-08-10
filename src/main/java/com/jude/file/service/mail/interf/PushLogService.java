package com.jude.file.service.mail.interf;

import com.jude.file.bean.mail.dao.PushLogDO;

import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 15:22 2018/8/6
 * @description: 推送记录
 */
public interface PushLogService {
    /**
     * 插入记录
     * @param pushLog 记录
     * @return boolean
     * */
    Boolean insert(PushLogDO pushLog);

    /**
     * 分页获取
     * @param index 第几页
     * @param size 每页条数
     * @return List<PushLog>
     * */
    List<PushLogDO> queryPage(Integer index, Integer size);

}
