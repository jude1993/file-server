package com.jude.file.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @author ：wupeng
 * @date ：Created in 17:14 2018/8/3
 * @description：
 */
public class SendEmail {
    /**发送人地址*/
    private static final String senderAddress = "893860859@qq.com";
  /** 收件人地址 */
  private static final String recipientsAddress = "8615736879498@kindle.cn";
    /**发送人账号*/
    private static final String senderAccount = "893860859@qq.com";
    /**发送人密码*/
    private static final String senderToken = "mzjswulxbichbeef";

  public static void main(String[] args) {
    SendEmail.sendFile("哈利波特全集", "auto", "F:\\kindle\\哈利波特全集.mobi");
  }

    /**发送邮件*/
    public static void sendFile(String title, String message, String filePath){
        /**1、邮件服务器参数配置*/
        Properties properties = new Properties();
        /**用户认证方式*/
        properties.put("mail.smtp.auth","true");
        /**设置传输协议*/
        properties.put("mail.transport.protocol","smtp");
        /**发件人SMTP地址*/
        properties.put("mail.smtp.host","smtp.qq.com");

        /**2、创建整个程序所需要的环境信息 session*/
        Session session = Session.getInstance(properties);
        /**调试信息在控制台打印*/
        session.setDebug(true);
        try {
            /**3、创建邮件实例对象*/
            MimeMessage email = getMimeMessage(title, message, filePath, session);
            /**4、根据session对象获取邮件传输对象Transport*/
            Transport transport = session.getTransport();
            /*设置发送人账户密码*/
            transport.connect(senderAccount,senderToken);
            transport.sendMessage(email,email.getAllRecipients());
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static MimeMessage getMimeMessage(String title, String message, String filePath, Session session) throws MessagingException, UnsupportedEncodingException {
        /*1、创建一个邮件对象*/
        MimeMessage email = new MimeMessage(session);

        /*2、设置发件人地址*/
        email.setFrom(new InternetAddress(senderAddress));

        /*3、设置收件人地址(可以增加多个收件人、抄送、密送)，即下面这一行代码书写多行*/
        email.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientsAddress));

        /*4、设置邮件主题*/
        email.setSubject(title,"UTF-8");

        /*5、邮件内容*/
        /*正文*/
        email.setContent(message,"text/html;charset=UTF-8");

        /*6、图片*/
        MimeBodyPart image = new MimeBodyPart();
        /*图片地址*/
        DataHandler dataHandler = new DataHandler(new FileDataSource("F:\\kindle\\Nvidia-noise-result.jpg"));
        /*将图片添加到节点*/
        image.setDataHandler(dataHandler);
        /*为节点设置ID，在文本中引用该ID*/
        image.setContentID("image1");

        /*7、创建文本节点*/
        MimeBodyPart text = new MimeBodyPart();
        /*将图片添加到文本内容中，可以使用上面设置的图片ID，或者http链接*/
        text.setContent("ID图片<img src='cid:image1'><br>链接图片<img src='https://www.bleepstatic.com/content/posts/2018/07/16/Nvidia-noise-result.jpg'>","text/html;charset=UTF-8");

        /*8、将图片节点和文本节点关联*/
        MimeMultipart connect = new MimeMultipart();
        connect.addBodyPart(image);
        connect.addBodyPart(text);
        /*关联关系 枚举?*/
        connect.setSubType("related");

        /*9、将文本+图片的混合节点封装为普通节点
        * 最终添加到邮件的Content是由多个BodyPart组成的Multipart，所以我们需要bodyPart
        * 上面并非bodyPart ,所以要把connect封装成BodyPart
        * */
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(connect);

        /*10、创建附件节点*/
        MimeBodyPart filePart = new MimeBodyPart();
        /*本地文件*/
        DataHandler dh = new DataHandler(new FileDataSource(filePath));
        /*将附件添加到节点*/
        filePart.setDataHandler(dh);
        /*设置附件名*/
        filePart.setFileName(MimeUtility.encodeText(dh.getName()));

        /*11、设置文本+图片 和 附件节点的关系，组合全部节点*/
        MimeMultipart resultPart = new MimeMultipart();
        //resultPart.addBodyPart(bodyPart);
        /*如果多个附件添加多次*/
        resultPart.addBodyPart(filePart);
        /*混合关系*/
        resultPart.setSubType("mixed");

        /*12、设置整个邮件关系，将最终节点添加到邮件*/
        email.setContent(resultPart);
        /*发送事件*/
        email.setSentDate(new Date());
        return email;
    }

}
