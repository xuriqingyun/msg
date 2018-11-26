package zhouxu.site.msgserver.pojo;


import zhouxu.site.msgserver.constants.MailConst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:mail定义
 * User: zhouxu
 * Date: 2018-11-14 14:22
 */
public class Mail {
    //发送方
    private String from;
    //接收方
    private String to;
    //邮件标题
    private String title;
    //邮件内容
    private String content;
    //邮件附件列表
    private List<String> attachments = new ArrayList<String>();
    //邮件图片列表
    private List<String> images = new ArrayList<String>();
    //邮件类型
    private String type;

    public Mail(){}

    public Mail(String from, String to, String title, String content, List<String> attachments, List<String> images, String type) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.content = content;
        this.attachments = attachments;
        this.images = images;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MailConst.MailType getMailType(){
        return MailConst.MailType.getMailType(this.getType());
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", attachments=" + attachments +
                ", images=" + images +
                ", type='" + type + '\'' +
                '}';
    }
}
