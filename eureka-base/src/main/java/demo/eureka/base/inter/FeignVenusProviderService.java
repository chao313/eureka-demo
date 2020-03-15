package demo.eureka.client.feign.provider.Venus;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这里用于上传文件
 * 这里指定了调用的微服务应用名称 provider
 * url : 一般用于调试接口
 * 注意：
 * 1.类似Controller，同样路径的只能有一个
 * 2.似乎只能存在一个参数
 */
@FeignClient(value = "provider")
public interface FeignVenusProviderService {

    /**
     * 这里采用了POST的方式
     * <p>
     * value :
     * 1.指定了调用URL的路径
     * 2.继承者的Controller路径
     * 注意:
     * POST必须用 RequestBody 才行
     */

    @RequestMapping(value = "/ProviderVenusController/venusPost", method = RequestMethod.POST)
    UserDetail venusPost(@RequestBody User user);


    /**
     * 这里采用了GET的方式
     * <p>
     * value :
     * 1.指定了调用URL的路径
     * 2.继承者的Controller路径
     * 注意:
     * GET方式，必须加上@RequestParam
     */
    @RequestMapping(value = "/ProviderVenusController/venusGet", method = RequestMethod.GET)
    UserDetail venusGet(User user);

}