package zhouxu.site.msgserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import zhouxu.site.msgserver.pojo.Mail;
import zhouxu.site.msgserver.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;



/**
 * Created with IntelliJ IDEA.
 * Description:邮件服务实现
 * User: zhouxu
 * Date: 2018-11-14 13:43
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //图片地址
    public final String IMAGE_PATH="images";
    //文件地址
    public final String FILE_PATH="files";

    @Override
    public boolean sendSimpleTextMail(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mail.getFrom());
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getTitle());
        simpleMailMessage.setText(mail.getContent());
        javaMailSender.send(simpleMailMessage);
        return true;
    }

    /**
     * @Author zhouxu
     * @Description 创建二进制文件消息体
     * @Date 2018/11/14 16:14
     * @Param [mail]
     * @return javax.mail.internet.MimeMessage
     * @throws
     **/
    MimeMessage buildMimeMessage(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(mail.getFrom());
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setSubject(mail.getTitle());
        mimeMessageHelper.setText(mail.getContent(),true);
        if(mail.getImages()!=null&&mail.getImages().size()>0){
            for(String imageId:mail.getImages()){
                mimeMessageHelper.addInline(imageId,new File(IMAGE_PATH+"/"+imageId+".png"));
            }
        }
        if(mail.getAttachments()!=null&&mail.getAttachments().size()>0){
            for (String file:mail.getAttachments()){
                mimeMessageHelper.addAttachment(file,new File(FILE_PATH+"/"+file));
            }
        }
        return mimeMessage;
    }

    @Override
    public boolean sendMimeMail(Mail mail) throws MessagingException {
        javaMailSender.send(this.buildMimeMessage(mail));
        return true;
    }


    @Override
    public boolean sendEmail(Mail mail) throws MessagingException {
        switch (mail.getMailType()){
            case SIMPLETEXT:return this.sendSimpleTextMail(mail);
            case MIME:return this.sendMimeMail(mail);
        }
        return false;
    }

}
