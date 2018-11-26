package zhouxu.site.msgclient.service;


import zhouxu.site.msgclient.pojo.Mail;

import javax.mail.MessagingException;

/**
 * Created with IntelliJ IDEA.
 * Description:邮件服务接口定义
 * User: zhouxu
 * Date: 2018-11-14 12:03
 */
public interface MailService {

    /**
     * @Author zhouxu
     * @Description 发送简单文本邮件
     * @Date 2018/11/14 13:38 
     * @Param [to, titile, content]
     * @return boolean
     * @throws        
     **/
    boolean sendSimpleTextMail(Mail mail);

    /**
     * @Author zhouxu
     * @Description 发送扩展邮件
     * @Date 2018/11/14 13:39
     * @Param [to, title, content]
     * @return boolean
     * @throws
     **/
    boolean sendMimeMail(Mail mail) throws MessagingException;

    /**
     * @Author zhouxu
     * @Description 统一发送邮件端口
     * @Date 2018/11/14 14:52
     * @Param [mail]
     * @return boolean
     * @throws
     **/
    boolean sendEmail(Mail mail) throws MessagingException;
}
