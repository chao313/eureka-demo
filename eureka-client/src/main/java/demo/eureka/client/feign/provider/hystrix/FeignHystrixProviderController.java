package demo.eureka.client.feign.provider.hystrix;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 用于调用provider提供服务Controller
 */
@RestController
@RequestMapping(value = "/feign/HystrixProvider")
public class FeignHystrixProviderController {

    @Resource
    private FeignHystrixProviderService feignService;

    @ApiOperation(value = "Hystrix 测试远程断路")
    @GetMapping("/getHystrixConsult")
    public ResponseEntity<String> getHystrixConsult(@ApiParam(name = "divisor", value = "除数") @RequestParam(value = "divisor") Integer divisor,
                                                    @ApiParam(name = "dividend", value = "被除数") @RequestParam(value = "dividend") Integer dividend) {
        return feignService.getHystrixConsult(divisor, dividend);

    }

}
