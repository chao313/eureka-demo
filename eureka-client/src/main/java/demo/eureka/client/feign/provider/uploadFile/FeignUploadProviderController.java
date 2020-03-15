package demo.eureka.client.feign.provider.uploadFile;

import demo.eureka.base.framework.Code;
import demo.eureka.base.framework.Response;
import demo.eureka.base.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用于调用provider提供服务Controller
 */
@RestController
@RequestMapping(value = "/feign/uploadProvider")
public class FeignUploadProviderController {

    @Resource
    private FeignUploadProviderService feignService;

    @ApiOperation(value = "Feign 上传文件")
    @PostMapping("/uploadFile")
    public ResponseEntity<byte[]> uploadFile(MultipartFile file) {
        return feignService.postUserDetail(file);

    }

}
