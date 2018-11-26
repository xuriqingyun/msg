package zhouxu.site.msgclient.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zhouxu.site.msgclient.utils.RestResult;


/**
 * Created with IntelliJ IDEA.
 * Description:统一异常处理
 * User: zhouxu
 * Date: 2018-11-14 17:28
 */
@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(Exception.class)
    public RestResult handler(Exception e){
        e.printStackTrace();
        return RestResult.Error(e);
    }
}
