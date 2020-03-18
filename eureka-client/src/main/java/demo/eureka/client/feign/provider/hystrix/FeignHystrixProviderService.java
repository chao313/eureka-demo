package demo.eureka.client.feign.provider.hystrix;

import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 测试 Feign 的 fallback 熔断器
 * ！！ 注意默认是关闭的，要开启
 */
@FeignClient(value = "provider", fallback = FallbackService.class)
public interface FeignHystrixProviderService {

    @RequestMapping(value = "/feign/hystrix/Provider/getHystrixConsult", method = RequestMethod.GET)
    ResponseEntity<String> getHystrixConsult(@ApiParam(name = "divisor", value = "除数") @RequestParam(value = "divisor") Integer divisor,
                                             @ApiParam(name = "dividend", value = "被除数") @RequestParam(value = "dividend") Integer dividend);

}

/**
 * 指定的 熔断器 执行结果
 * 1.必须要 @Service -> 不然无法执行成功 (在spring中寻找)
 * 2.必须继承接口
 */
@Service
class FallbackService implements FeignHystrixProviderService {

    @Override
    public ResponseEntity<String> getHystrixConsult(Integer divisor, Integer dividend) {

        return ResponseEntity.ok(("这个是fallback的处理接口，当服务不可以时，调用这个"));
    }
}