package com.jude.file.mail;

import com.jude.file.bean.ResponseBean;
import com.jude.file.common.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;


/**
 * @author ：wupeng
 * @date ：Created in 9:51 2018/8/6
 * @description：
 */
@Component
public class KindlePush {
    @Value("mail.connect.senderAddress")
    private String senderAddress;
    @Value("mail.connect.recipientsAddress")
    private String recipientsAddress;
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

    private static final Logger logger = LoggerFactory.getLogger(KindlePush.class);

    public ResponseBean push(String title, String message, List<String> filePath){
        /*邮件参数*/
        Properties arguments = new Properties();
        arguments.put(Constants.AUTH_MAIL,authMail);
        arguments.put(Constants.PROTOCOL_MAIL,protocolMail);
        arguments.put(Constants.HOST_MAIL,hostMail);
        Session session = Session.getInstance(arguments);
        /*控制台打印调试信息*/
        session.setDebug(true);
        try {
            MimeMessage mail = MailUtils.getMimeMessage(senderAddress, recipientsAddress, title, message, filePath, session);
            Transport transport = session.getTransport();
            transport.connect(senderAccount, senderToken);
            transport.sendMessage(mail,mail.getAllRecipients());
        } catch (MessagingException e) {
            return ResponseBean.error("推送异常");
        }
        return ResponseBean.success("推送成功");
    }


}
