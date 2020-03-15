package demo.eureka.client.feign.provider.uploadFile;

import demo.eureka.base.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 这里用于上传文件
 * 这里指定了调用的微服务应用名称 provider
 * url : 一般用于调试接口
 * 注意：
 * 1.类似Controller，同样路径的只能有一个
 * 2.似乎只能存在一个参数
 */
@FeignClient(value = "provider")
public interface FeignUploadProviderService {

    /**
     * 这里采用了POST的方式
     * 1.produces 和 consumes 是必须的
     * 2.注意这里的是 @RequestPart
     * <p>
     * value 指定了调用URL的路径
     */
    @RequestMapping(value = "/providerUploadFileController/uploadFile", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<byte[]> postUserDetail(@RequestPart(value = "file") MultipartFile file);

}