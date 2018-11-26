package zhouxu.site.msgclient.utils;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * Description:json 工具
 * User: zhouxu
 * Date: 2018-11-26 10:32
 */
public class JsonUtils {

    /**
     * @Author zhouxu
     * @Description 对象转String
     * @Date 2018/11/26 10:33
     * @Param [object]
     * @return java.lang.String
     * @throws
     **/
    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * @Author zhouxu
     * @Description //String转对象
     * @Date 2018/11/26 10:35
     * @Param [data, tClass]
     * @return T
     * @throws
     **/
    public static <T> T parse(String data,Class<T> tClass){
        Gson gson = new Gson();
        return gson.fromJson(data,tClass);
    }
}
