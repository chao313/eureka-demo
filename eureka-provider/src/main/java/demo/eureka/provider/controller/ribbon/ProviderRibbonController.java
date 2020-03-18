package demo.eureka.provider.controller.ribbon;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import demo.eureka.client.feign.provider.Venus.FeignVenusProviderService;
import demo.eureka.provider.config.ServerConfig;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 提供服务者的Controller，
 * 用于测试Ribbon
 */
@Slf4j
@RestController
@RequestMapping(value = "/providerRibbonController")
public class ProviderRibbonController {

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 暴露的http服务
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "采用GET的方式去传递参数")
    @PostMapping(value = "/postRibbonUserDetail")
    public UserDetail postRibbonUserDetail(@RequestBody User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(user.getAge());
        userDetail.setName(user.getName());
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(user.getName() + ":" + user.getAge() + "使用POST的方式请求:当前响应的端口号是:" + serverConfig.getServerPort());
        return userDetail;
    }

}
