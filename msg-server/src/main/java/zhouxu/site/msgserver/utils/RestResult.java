package zhouxu.site.msgserver.utils;


import zhouxu.site.msgserver.exception.BizException;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:用于统一数据标准
 * User: zhouxu
 * Date: 2018-11-14 16:41
 */
public class RestResult extends HashMap {

    //状态编码:200/400/500....
    public final String CODE="code";

    //数据
    public final Object DATA="data";

    //状态值：true/false
    public final String STATUS="status";

    //消息值:null/异常消息
    public final String MESSAGE="message";


    public RestResult(Object code,Object data,boolean status,String message){
        this.put(CODE,code);
        this.put(DATA,data);
        this.put(STATUS,status);
        this.put(MESSAGE,message);
    }

    /**
     * @Author zhouxu
     * @Description //错误结果
     * @Date 2018/11/14 16:55
     * @Param [code, message]
     * @return RestResult
     * @throws
     **/
    public static RestResult Error(String message){
        return new RestResult("unkown",null,false,message);
    }

    /**
     * @Author zhouxu
     * @Description //错误结果
     * @Date 2018/11/14 16:55
     * @Param [code, message]
     * @return RestResult
     * @throws
     **/
    public static RestResult Error(Exception e){
        if(e instanceof BizException){
            return new RestResult(((BizException)e).getCode(),null,false,e.getMessage());
        }
        return new RestResult("unkown",null,false,e.getMessage());
    }

    /**
     * @Author zhouxu
     * @Description //正确统一结果
     * @Date 2018/11/14 16:57
     * @Param [data]
     * @return RestResult
     * @throws
     **/
    public static RestResult Success(Object data){
        return new RestResult("200",data,true,null);
    }




}
