package zhouxu.site.msgserver.exception;


import zhouxu.site.msgserver.constants.RestConst;

/**
 * Created with IntelliJ IDEA.
 * Description:异常消息定义
 * User: zhouxu
 * Date: 2018-11-14 16:49
 */
public class BizException extends RuntimeException{

    //告警状态
    private int code;

    public BizException(int code,String message) {
        super(message);
        this.code = code;
    }

    public BizException(RestConst.RestEnum restEnum){
        super(restEnum.getMessage());
        this.code = restEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
