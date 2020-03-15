package demo.eureka.provider.controller;

import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import demo.eureka.client.feign.provider.Venus.FeignVenusProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供服务者的Controller，具体的路径在接口里面
 */
@Slf4j
@RestController
public class ProviderVenusController implements FeignVenusProviderService {

    @Override
    public UserDetail venusPost(User user) {

        UserDetail userDetail = new UserDetail();
        userDetail.setAge(user.getAge());
        userDetail.setName(user.getName());
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(user.getName() + ":" + user.getAge() + "使用Venus的POST方式请求");
        return userDetail;
    }

    @Override
    public UserDetail venusGet(User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(user.getAge());
        userDetail.setName(user.getName());
        /**
         * 稍微处理一下
         */
        userDetail.setIntroduce(user.getName() + ":" + user.getAge() + "使用Venus的GET方式请求");
        return userDetail;
    }


}
