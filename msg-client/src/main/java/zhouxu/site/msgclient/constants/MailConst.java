package zhouxu.site.msgclient.constants;

/**
 * Created with IntelliJ IDEA.
 * Description:mail 枚举定义
 * User: zhouxu
 * Date: 2018-11-14 14:39
 */
public class MailConst {

    public enum  MailType{
        SIMPLETEXT("simpletext"), //简单文本邮件
        MIME("mime");//扩展邮件

        private String type;

        MailType(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }

        /**
         * @Author zhouxu
         * @Description 通过type获取enum
         * @Date 2018/11/14 15:01
         * @Param [type]
         * @return MailConst.MailType
         * @throws
         **/
        public static MailType getMailType(String type){
            for(MailType mailType:MailType.values()){
                if(mailType.getType().equals(type)){
                    return  mailType;
                }
            }
            return MailType.SIMPLETEXT;
        }
    }
}
