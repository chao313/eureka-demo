package demo.eureka.client.ribbon;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import demo.eureka.client.feign.provider.getAndPost.FeignGetAndPostProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用于调用provider提供服务Controller
 */
@RestController
@RequestMapping(value = "/feign/ribbon")
public class RibbonProviderController {

    /**
     * 注入 restTemplate -> ribbon
     */
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "Feign 采用POST的方式去传递参数", notes = "")
    @PostMapping(value = "/Provider/postRibbonUserDetail")
    public UserDetail postRibbonUserDetail(@RequestBody User user) {
        return restTemplate.postForObject("http://provider/providerRibbonController/postRibbonUserDetail", user, UserDetail.class);
    }

    @ApiOperation(value = "Feign 采用POST的方式去传递参数", notes = "")
    @PostMapping(value = "/Provider2/postRibbonUserDetail")
    public UserDetail postRibbonUserDetail2(@RequestBody User user) {

        return restTemplate.postForObject("http://provider2/providerRibbonController/postRibbonUserDetail", user, UserDetail.class);

    }
}
