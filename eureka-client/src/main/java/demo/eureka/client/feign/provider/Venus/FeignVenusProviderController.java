package demo.eureka.client.feign.provider.Venus;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用于调用provider提供服务Controller
 */
@RestController
@RequestMapping(value = "/feign/VenusProvider")
public class FeignVenusProviderController {

    @Resource
    demo.eureka.client.feign.provider.Venus.FeignVenusProviderService feignVenusProviderService;

    @RequestMapping(value = "/venusPost", method = RequestMethod.POST)
    public UserDetail venusPost(User user) {
        return feignVenusProviderService.venusPost(user);
    }

    @RequestMapping(value = "/venusGet", method = RequestMethod.GET)
    public UserDetail venusGet(User user) {
        return feignVenusProviderService.venusGet(user);
    }
}
