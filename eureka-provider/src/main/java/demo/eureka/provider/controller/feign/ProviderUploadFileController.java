package demo.eureka.provider.controller.feign;

import demo.eureka.base.framework.Code;
import demo.eureka.base.framework.Response;
import demo.eureka.base.pojo.User;
import demo.eureka.base.pojo.UserDetail;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * 提供服务者的Controller
 */
@Slf4j
@RestController
@RequestMapping(value = "/providerUploadFileController")
public class ProviderUploadFileController {

    @PostMapping("/uploadFile")
    public Response uploadFile(MultipartFile file) {
        Response response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setContent(file.getOriginalFilename());
            log.info("上传结果:{}", true);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.getMessage());
            response.addException(e);
            log.error("异常 ：{} ", e.getMessage(), e);
        }
        return response;

    }
}
