package demo.eureka.config.client.controller;

import demo.eureka.config.client.config.ConfigInfoFromConfigServerProperties;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 */
@Slf4j
@RestController
@RequestMapping(value = "/config/client")
public class ClientController {

    @Autowired
    private ConfigInfoFromConfigServerProperties configInfoFromConfigServerProperties;

    @ApiOperation(value = "测试重服务端获取配置")
    @GetMapping(value = "/ConfigInfoFromConfigServer")
    public String ConfigInfoFromConfigServer() {
        return configInfoFromConfigServerProperties.getInfo();
    }
}
