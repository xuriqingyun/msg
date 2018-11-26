package zhouxu.site.msgclient.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * Description:用于记录
 * User: zhouxu
 * Date: 2018-11-14 13:55
 */
@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //时间格式
    private final String DATA_FORMAT="yyyy-MM-dd hh:mm:ss";

    @Pointcut("execution(public * zhouxu.site.msgclient.api.*.*(..))")
    public void logPoint(){
    }

    /**
     * @Author zhouxu
     * @Description 前置通知
     * @Date 2018/11/14 14:08
     * @Param [joinPoint]
     * @return void
     * @throws
     **/
    @Before("logPoint()")
    public void doBefore(JoinPoint joinPoint){
        this.loggerBefore(joinPoint);
    }

    /**
     * @Author zhouxu
     * @Description 后置通知
     * @Date 2018/11/14 14:08
     * @Param [joinPoint]
     * @return void
     * @throws
     **/
    @After("logPoint()")
    public void doAfter(JoinPoint joinPoint){
        this.loggerAfter(joinPoint);
    }

    /**
     * @Author zhouxu
     * @Description 返回通知
     * @Date 2018/11/14 14:09
     * @Param [object]
     * @return void
     * @throws
     **/
    @AfterReturning( returning = "object",pointcut = "logPoint()")
    public void doAfterReturn(Object object){
        this.loggerReturn(object);
    }

    /**
     * @Author zhouxu
     * @Description 方法调用前日志记录
     * @Date 2018/11/14 14:10
     * @Param [joinPoint]
     * @return void
     * @throws
     **/
    public void loggerBefore(JoinPoint joinPoint){
        logger.info("----------------------------");
        logger.info("start time:" + new SimpleDateFormat(DATA_FORMAT).format(new Date()));
        //TODO:获取request
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String remoteAddr = request.getRemoteAddr();
        logger.info("ip={}"+remoteAddr);

        String requestURI = request.getRequestURI();
        logger.info("url={}",requestURI);

        String method = request.getMethod();
        logger.info("method={}",method);

        @SuppressWarnings("rawtypes")
        Class declaringType = joinPoint.getSignature().getDeclaringType();

        String methodName = joinPoint.getSignature().getName();
        logger.info("class_method={}",declaringType.getName()+"."+methodName);

        Object[] args = joinPoint.getArgs();
        logger.info("args={}",args);
    }

    /**
     * @Author zhouxu
     * @Description 方法调用后调用
     * @Date 2018/11/14 14:10
     * @Param [joinPoint]
     * @return void
     * @throws
     **/
    public void loggerAfter(JoinPoint joinPoint){
        logger.info("end time:" + new SimpleDateFormat(DATA_FORMAT).format(new Date()));
    }

    /**
     * @Author zhouxu
     * @Description 方法调用后调用
     * @Date 2018/11/14 14:11
     * @Param [object]
     * @return void
     * @throws
     **/
    public void loggerReturn(Object object){
        logger.info("return={}",object);
    }

}
