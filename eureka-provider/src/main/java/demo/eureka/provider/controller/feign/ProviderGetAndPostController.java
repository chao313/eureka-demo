package demo.eureka.provider.controller.feign;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供服务者的Controller
 */
@RestController
@RequestMapping(value = "/providerGetAndPostController")
public class ProviderGetAndPostController {

    /**
     * 暴露的http服务
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "采用POST的方式去传递参数", notes = "1.这里需要使用 @RequestBody</p>2.这路用于暴露http的请求")
    @PostMapping(value = "/postUserDetail")
    public UserDetail postUserDetail(@RequestBody User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(user.getAge());
        userDetail.setName(user.getName());
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(user.getName() + ":" + user.getAge() + "使用POST的方式请求");
        return userDetail;
    }

    @ApiOperation(value = "采用GET的方式去传递参数(多字段)", notes = "这里把多个字段拆分为多个字段")
    @GetMapping(value = "/getUserDetail/useFields")
    public UserDetail getUserDetail(String name, String age) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(name);
        userDetail.setName(age);
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(name + ":" + "使用GET的方式请求:使用多字段方式");
        return userDetail;
    }

    @ApiOperation(value = "采用GET的方式去传递参数", notes = "这里使用map")
    @GetMapping(value = "/getUserDetail/useMap")
    public UserDetail getUserDetail(@RequestParam HashMap<String, String> map) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(map.get("name"));
        userDetail.setName(map.get("age"));
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(userDetail.getName() + ":" + userDetail.getAge() + ":" + "使用GET的方式请求:使用map方式");
        return userDetail;
    }

    /**
     * 暴露的http服务
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "采用GET的方式去传递参数(通过拦截器的方式,把GET的请求体转换为请求参数)", notes = "这里使用正常使用")
    @GetMapping(value = "/getUserDetail")
    public UserDetail getUserDetail(User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(user.getAge());
        userDetail.setName(user.getName());
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(user.getName() + ":" + user.getAge() + "使用GET的正常方式请求(通过拦截器的方式,把GET的请求体转换为请求参数)");
        return userDetail;
    }


}
