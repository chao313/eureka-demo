package demo.eureka.client.feign.provider.getAndPost;

import demo.eureka.base.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 这里指定了调用的微服务应用名称 provider
 * url : 一般用于调试接口
 * 注意：
 * 1.类似Controller，同样路径的只能有一个
 * 2.似乎只能存在一个参数
 */
@FeignClient("provider")
public interface FeignGetAndPostProviderService {

    /**
     * 这里采用了POST的方式
     * <p>
     * value 指定了调用URL的路径
     */
    @RequestMapping(value = "/providerGetAndPostController/postUserDetail", method = RequestMethod.POST)
    ResponseEntity<byte[]> postUserDetail(@RequestBody User user);

    /**
     * 这里采用了GET的方式 -> 各个属性单独传递
     * <p>
     * value 指定了调用URL的路径
     */
    @RequestMapping(value = "/providerGetAndPostController/getUserDetail/useFields", method = RequestMethod.GET)
    ResponseEntity<byte[]> getUserDetailUseFields(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age);

    /**
     * 这里采用了GET的方式 -> 使用map
     * <p>
     * value 指定了调用URL的路径
     */
    @RequestMapping(value = "/providerGetAndPostController/getUserDetail/useMap", method = RequestMethod.GET)
    ResponseEntity<byte[]> getUserDetailUseMap(@RequestParam(value = "map") Map<String, String> map);


    /**
     * 这里采用了GET的方式
     * <p>
     * value 指定了调用URL的路径
     */
    @RequestMapping(value = "/providerGetAndPostController/getUserDetail", method = RequestMethod.GET)
    ResponseEntity<byte[]> getUserDetail(User user);

}