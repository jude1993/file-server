package com.jude.file.service.mail.impl;

import com.alibaba.fastjson.JSON;
import com.jude.file.bean.ResponseBean;
import com.jude.file.bean.mail.bo.MailBO;
import com.jude.file.bean.mail.dao.KindleConfigDO;
import com.jude.file.bean.mail.dao.OperationLog;
import com.jude.file.bean.mail.dao.PushLogDO;
import com.jude.file.common.LogUtils;
import com.jude.file.common.MailUtils;
import com.jude.file.mail.Constants;
import com.jude.file.mapper.mail.KindleConfigMapper;
import com.jude.file.service.mail.interf.OperationLogService;
import com.jude.file.service.mail.interf.PushLogService;
import com.jude.file.service.mail.interf.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * @author ：wupeng
 * @date ：Created in 15:45 2018/8/6
 * @description：推送服务
 */
@Service
public class PushServiceImpl implements PushService {

    @Value("${mail.connect.senderAddress}")
    private String senderAddress;
    @Value("${mail.connect.senderAccount}")
    private String senderAccount;
    @Value("${mail.connect.senderToken}")
    private String senderToken;
    @Value("${mail.args.authMail}")
    private String authMail;
    @Value("${mail.args.protocolMail}")
    private String protocolMail;
    @Value("${mail.args.hostMail}")
    private String hostMail;

    @Autowired
    private KindleConfigMapper configMapper;
    @Autowired
    private PushLogService pushLogService;
    @Autowired
    private OperationLogService operationLogService;

    private static final Logger logger = LoggerFactory.getLogger(PushServiceImpl.class);

    @Override
    public ResponseBean push(Long userId, MailBO mailBO) {
        LogUtils.info(logger,"userID={},发起推送{}",userId,JSON.toJSONString(mailBO));
        String fileName = getFileName(mailBO.getFilePath());
        /*相关校验*/
        /*获取用户设置的邮箱*/
        KindleConfigDO kindleConfig = configMapper.selectByUserId(userId);
        if(kindleConfig == null){
            operationLogService.insert(new OperationLog(userId,fileName+"推送失败,未设置邮箱"));
            return ResponseBean.fail("未设置kindle邮箱",false);
        }
        if(!kindleConfig.getStatus()){
            operationLogService.insert(new OperationLog(userId,fileName+"推送失败,未设置邮箱"));
            return ResponseBean.fail("未设置kindle邮箱",false);
        }
        /*异步推送*/
        asynPush(kindleConfig,mailBO,userId);
        operationLogService.insert(new OperationLog(userId,fileName+":发起推送"));
        return ResponseBean.success("发起推送",true);
    }

    private String getFileName(List<String> filePath){
        StringBuilder sb = new StringBuilder();
        filePath.forEach(path ->{
            sb.append(path.substring(path.lastIndexOf(System.getProperty("file.separator")) + 1)).append("#");
        });
        String fileName = sb.toString();
        return fileName.substring(0,fileName.length()-1);
    }

    private void asynPush(KindleConfigDO kindleConfig, MailBO mailBO,Long userId){
        String fileName = getFileName(mailBO.getFilePath());
        new Thread(new Runnable(){
            @Override
            public void run() {
                /*推送*/
                /*邮件参数*/
                Properties arguments = new Properties();
                arguments.put(Constants.AUTH_MAIL,authMail);
                arguments.put(Constants.PROTOCOL_MAIL,protocolMail);
                arguments.put(Constants.HOST_MAIL,hostMail);

                Session session = Session.getInstance(arguments);
                /*控制台打印调试信息*/
                session.setDebug(true);
                try {
                    MimeMessage mail = MailUtils.getMimeMessage(senderAddress, kindleConfig.getKindleEmail(), mailBO.getTitle(), mailBO.getMessage(), mailBO.getFilePath(), session);

                    Transport transport = session.getTransport();
                    transport.connect(senderAccount, senderToken);
                    transport.sendMessage(mail,mail.getAllRecipients());
                } catch (MessagingException e) {
                    /*推送失败,插入日志*/
                    operationLogService.insert(new OperationLog(userId,fileName+":推送失败"));
                    LogUtils.error(logger,"推送异常，异常信息{}",e);
                }
                /*推送成功,插入日志*/
                operationLogService.insert(new OperationLog(userId,fileName+":推送成功"));
                pushLogService.insert(new PushLogDO(userId,kindleConfig.getKindleEmail(),fileName,false, new Date()));
            }
        }).start();
  }

}
