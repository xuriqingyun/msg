package zhouxu.site.msgclient.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouxu.site.msgclient.utils.RestResult;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-11-14 17:43
 */
@RestController
@RequestMapping("/api/v1/")
public class HealthController {
    @GetMapping("/health")
    public RestResult health(){
        return RestResult.Success("true");
    }
}
