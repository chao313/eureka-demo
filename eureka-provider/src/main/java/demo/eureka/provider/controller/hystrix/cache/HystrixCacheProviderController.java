package demo.eureka.provider.controller.hystrix.cache;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用于调用provider提供服务Controller
 * 这里使用了断路器hystrix @HystrixCommand
 */
@Slf4j
@RestController
@RequestMapping(value = "/feign/hystrixCache")
public class HystrixCacheProviderController {

    int i = 0;
    int j = 0;

    @ApiOperation(value = "hystrix 测试断路", notes = "1.除数和被除数,发生错误就调用 fallbackMethod 方法")

    @CacheResult
    @HystrixCommand
    @GetMapping(value = "/Provider/getHystrixCacheResult")
    public List<String> getHystrixSimpleDateFormat() {
        i = 0;
        j = 0;
        List<String> result = new ArrayList<>();
        result.add(this.getCacheResult(i));
        result.add(this.getCacheResult(i));
        result.add(this.getCacheResult(i));
//        result.add(this.getSimpleResult());
//        result.add(this.getSimpleResult());
//        result.add(this.getSimpleResult());
        return result;
    }

    @CacheResult
    @HystrixCommand
    public String getCacheResult(int i) {
        log.info("i:{}", i);
        return "第" + "次请求" + ":" + Math.random();
    }


    public String getSimpleResult() {
        return "第" + j++ + "次请求" + ":" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S").format(new Date());
    }


}
