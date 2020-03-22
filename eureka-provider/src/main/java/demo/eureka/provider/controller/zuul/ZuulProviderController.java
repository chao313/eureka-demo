package demo.eureka.provider.controller.zuul;

import demo.eureka.base.pojo.UserDetail;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于和zuul项目配合
 */
@Slf4j
@RestController
@RequestMapping(value = "/provider/zuulProvider")
public class ZuulProviderController {


    int i = 0;

    @ApiOperation(value = "测试重试机制")
    @GetMapping(value = "/getRequestsRetry")
    public String getRequestsRetry() throws InterruptedException {

        log.info("主动sleep:1000");
        Thread.sleep(1000);
        log.info("请求次数:{}", i++);
        return "success";
    }

    @ApiOperation(value = "测试HEAD")
    @GetMapping(value = "/getRequestsHeaders")
    public String getRequestsHeaders(@RequestHeader HttpHeaders headers) {

        return headers.toString();

    }

}
