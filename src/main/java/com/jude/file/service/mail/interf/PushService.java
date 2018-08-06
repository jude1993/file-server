package com.jude.file.service.mail.interf;

import com.jude.file.bean.ResponseBean;
import com.jude.file.bean.mail.bo.MailBO;

/**
 * @author ：wupeng
 * @date ：Created in 15:40 2018/8/6
 * @description：推送服务
 */
public interface PushService {
    /**
     * 推送邮件
     * @param userId 用户id
     * @param mailBO 邮件内容
     * @return ResponseBean
     * */
    ResponseBean push(Long userId, MailBO mailBO);

}
