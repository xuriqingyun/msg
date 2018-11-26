package zhouxu.site.msgserver.constants;

/**
 * Created with IntelliJ IDEA.
 * Description:Rest相关枚举定义
 * User: zhouxu
 * Date: 2018-11-14 17:00
 */
public class RestConst {

    /**
     * @Author zhouxu
     * @Description 通用枚举定义
     * @Date 2018/11/14 17:08
     * @Param
     * @return
     * @throws
     **/
    public enum CommonEnum implements RestEnum{
        SUCCESS(200,""),
        CREATED(201,"CREAED"),
        BAD_REQUEST(400,"400"),
        ERROR_PASSWORD(420,"420"),
        Unauthorized(401, "Unauthorized"),
        Forbidden(403, "Forbidden");

        //编码
        private int code;

        //消息
        private String message;

        CommonEnum(int code,String message){
            this.code = code;
            this.message = message;
        }
        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getMessage() {
            return this.message;
        }
    }

    public interface RestEnum{
        /**
         * @Author zhouxu
         * @Description //获取编码
         * @Date 2018/11/14 17:03
         * @Param []
         * @return int
         * @throws
         **/
        int getCode();
        /**
         * @Author zhouxu
         * @Description //获取消息
         * @Date 2018/11/14 17:03
         * @Param []
         * @return java.lang.String
         * @throws
         **/
        String getMessage();
    }
}
