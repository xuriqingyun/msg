package zhouxu.site.msgserver.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhouxu.site.msgserver.pojo.Mail;
import zhouxu.site.msgserver.service.MailService;
import zhouxu.site.msgserver.utils.JsonUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:消息消费监听
 * User: zhouxu
 * Date: 2018-11-26 12:10
 */
@Component
@RabbitListener(queues = "mail-queue")
public class MsgListener {

    @Autowired
    private MailService mailService;

    private static Logger logger = LoggerFactory.getLogger(MsgListener.class);

    @RabbitHandler
    public void onMessage(String msg,Channel channel, Message message){
        try {
            logger.info("recive message:"+msg);
            logger.info("========================handeling message ===============================");
            Mail mail = JsonUtils.parse(msg, Mail.class);
            mailService.sendEmail(mail);
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            logger.info("========================handeled message ===============================");
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            logger.info("receiver fail");
        }

    }
}
