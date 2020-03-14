package demo.eureka.client.provider;

import demo.eureka.base.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用于调用provider提供服务Controller
 */
@RestController
@RequestMapping(value = "/feign/getAndPostProvider")
public class FeignGetAndPostProviderController {

    @Resource
    private FeignGetAndPostProviderService feignService;

    @ApiOperation(value = "Feign 采用POST的方式去传递参数", notes = "1.这里需要使用 @RequestBody")
    @PostMapping(value = "/postUserDetail")
    public ResponseEntity<byte[]> postUserDetail(@RequestBody User user) {

        return feignService.postUserDetail(user);
    }

    @ApiOperation(value = "Feign 采用GET的方式去传递参数(拆分为多个属性)", notes = "1.这里的参数的属性单独的传递")
    @GetMapping(value = "/getUserDetail/useFields")
    public ResponseEntity<byte[]> getUserDetailUseFields(String name, String age) {

        return feignService.getUserDetailUseFields(name, age);
    }

    @ApiOperation(value = "Feign 采用GET的方式去传递参数(使用Map)", notes = "1.这里的属性全部放入Map里面<p>2.swagger使用map不懂，现在程序中设置指定值")
    @GetMapping(value = "/getUserDetail/useMap")
    public ResponseEntity<byte[]> getUserDetailUseMap(Map<String, String> map) {
        map.put("name", "client放入的参数值 name");
        map.put("age", "client放入的参数值 age");
        return feignService.getUserDetailUseMap(map);
    }

    @ApiOperation(value = "Feign 采用GET的方式去传递参数(正常的方式)", notes = "这里使用拦截器")
    @GetMapping(value = "/getUserDetail")
    public ResponseEntity<byte[]> getUserDetail(User user) {

        return feignService.getUserDetail(user);
    }


}
