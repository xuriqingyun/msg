package zhouxu.site.msgclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhouxu.site.msgclient.constants.MailConst;
import zhouxu.site.msgclient.pojo.Mail;
import zhouxu.site.msgclient.service.MailService;
import zhouxu.site.msgclient.utils.RestResult;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-11-14 14:20
 */
@RestController
@RequestMapping("api/v1/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public RestResult sendMail(@RequestBody Mail mail)  {
        return RestResult.Success(mailService.sendEmail(mail));
    }

    @GetMapping("/sendDemo")
    public RestResult sendDemoMail() {
        Mail mail = new Mail("devoperation@163.com","1136112121@qq.com","mq mail",
                "this is a simpletext mail",
                null,
                null,
                MailConst.MailType.SIMPLETEXT.getType());
        return RestResult.Success(mailService.sendEmail(mail));
    }
}
