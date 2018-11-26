package zhouxu.site.msgclient.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zhouxu.site.msgclient.pojo.Mail;
import zhouxu.site.msgclient.service.MailService;
import zhouxu.site.msgclient.utils.JsonUtils;




/**
 * Created with IntelliJ IDEA.
 * Description:邮件服务实现
 * User: zhouxu
 * Date: 2018-11-14 13:43
 */
@Service
public class MailServiceImpl implements MailService {

    @Value("${mail-exhange}")
    private String exhange;
    @Value("${mail-routingKey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendSimpleTextMail(Mail mail) {
        try{
            rabbitTemplate.convertAndSend(exhange,routingKey,JsonUtils.toJson(mail));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean sendMimeMail(Mail mail)  {
        return false;
    }

    @Override
    public boolean sendEmail(Mail mail)  {
        switch (mail.getMailType()){
            case SIMPLETEXT:return this.sendSimpleTextMail(mail);
            case MIME:return this.sendMimeMail(mail);
        }
        return false;
    }
}
