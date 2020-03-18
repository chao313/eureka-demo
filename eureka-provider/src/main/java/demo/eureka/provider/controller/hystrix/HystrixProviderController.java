package demo.eureka.provider.controller.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * 用于调用provider提供服务Controller
 * 这里使用了断路器hystrix @HystrixCommand
 */
@RestController
@RequestMapping(value = "/feign/hystrix")
public class HystrixProviderController {


    @ApiOperation(value = "hystrix 测试断路", notes = "1.除数和被除数,发生错误就调用 fallbackMethod 方法")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GetMapping(value = "/Provider/getHystrixConsult")
    public String getHystrixConsult(
            @ApiParam(name = "divisor", value = "除数") @RequestParam(value = "divisor") Integer divisor,
            @ApiParam(name = "dividend", value = "被除数") @RequestParam(value = "dividend") Integer dividend) {
        return String.valueOf(divisor / dividend);
    }

    /**
     * 注意， 作为fallbackMethod的函数，
     * 参数:  必须要和调用者的参数一致
     * 返回值: 必须为调用者的本身或则子类
     */
    public String fallbackMethod(Integer divisor, Integer dividend) {
        return "发生异常,被除数为0";
    }

}
