package com.jude.file.common;

import com.jude.file.mail.KindlePush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author ：wupeng
 * @date ：Created in 14:00 2018/8/6
 * @description：
 */
public class MailUtils {
    private static final Logger logger = LoggerFactory.getLogger(KindlePush.class);

    public static MimeMessage getMimeMessage(String senderAddress, String recipientsAddress, String title, String message, List<String> filePath, Session session) throws MessagingException {
        MimeMessage mail = new MimeMessage(session);
        mail.setFrom(new InternetAddress(senderAddress));
        mail.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientsAddress));
        mail.setSubject(title,"UTF-8");
        mail.setContent(message,"text/html;charset=UTF-8");
        MimeMultipart filePart = getMultiPart(message, filePath);
        mail.setContent(filePart);
        mail.setSentDate(new Date());
        return mail;
    }

    private static MimeMultipart getMultiPart(String message, List<String> filePath) {
        MimeMultipart resultPart = new MimeMultipart();
        filePath.forEach(path ->{
            MimeBodyPart bodyPart = new MimeBodyPart();
            DataHandler dataHandler = new DataHandler(new FileDataSource(path));
            try {
                bodyPart.setDataHandler(dataHandler);
                bodyPart.setFileName(MimeUtility.encodeText(dataHandler.getName()));
                resultPart.addBodyPart(bodyPart);
            } catch (MessagingException e) {
                LogUtils.error(logger,"文件发送失败{}"+path.substring(path.lastIndexOf(System.lineSeparator())));
            } catch (UnsupportedEncodingException e) {
                LogUtils.error(logger,"不支持的编码格式{}"+path.substring(path.lastIndexOf(System.lineSeparator())));
                e.printStackTrace();
            }
        });
        return resultPart;
    }
}
