package com.jude.file.service.mail.impl;

import com.jude.file.bean.ResponseBean;
import com.jude.file.bean.mail.bo.MailBO;
import com.jude.file.bean.mail.dao.KindleConfig;
import com.jude.file.bean.mail.dao.PushLog;
import com.jude.file.common.MailUtils;
import com.jude.file.mail.Constants;
import com.jude.file.mapper.UserMapper;
import com.jude.file.mapper.mail.KindleConfigMapper;
import com.jude.file.service.mail.interf.PushLogService;
import com.jude.file.service.mail.interf.PushService;
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

    @Value("mail.connect.senderAddress")
    private String senderAddress;
    @Value("mail.connect.senderAccount")
    private String senderAccount;
    @Value("mail.connect.senderToken")
    private String senderToken;
    @Value("mail.connect.authMail")
    private String authMail;
    @Value("mail.connect.protocolMail")
    private String protocolMail;
    @Value("mail.connect.hostMail")
    private String hostMail;

    @Autowired
    private KindleConfigMapper configMapper;
    @Autowired
    private PushLogService pushLogService;

    @Override
    public ResponseBean push(Long userId, MailBO mailBO) {
        /*获取用户设置的邮箱*/
        KindleConfig kindleConfig = configMapper.selectByUserId(userId);
        if(!kindleConfig.getStatus()){
            return ResponseBean.fail("未将邮箱添加亚马逊到信任邮箱列表",false);
        }
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
            pushLogService.insert(new PushLog(userId,kindleConfig.getKindleEmail(),getFileName(mailBO.getFilePath()),false,new Date()));
            return ResponseBean.error("推送异常",true);
        }
        /*推送成功,插入日志*/
        pushLogService.insert(new PushLog(userId,kindleConfig.getKindleEmail(),getFileName(mailBO.getFilePath()),true,new Date()));
        return ResponseBean.success("推送成功",true);
    }

    private String getFileName(List<String> filePath){
        StringBuilder sb = new StringBuilder();
        filePath.forEach(path ->{
            sb.append(path.substring(path.lastIndexOf(System.lineSeparator()) + 1)).append("#");
        });
        String fileName = sb.toString();
        return fileName.substring(0,fileName.length()-1);
    }
}
