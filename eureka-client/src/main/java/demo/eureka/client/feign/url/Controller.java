package demo.eureka.client.feign.url;

//import demo.eureka.client.feign.url.FeignBaiduService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/feign")
public class Controller {

    @Resource
    private FeignBaiduService feignBaiduService;

    @Resource
    private FeignGitHubApiService feignGitHubApiService;

    @GetMapping(value = "/feign/github/api")
    public ResponseEntity<byte[]> githubSearch(@RequestParam(value = "q") String q) {

        return feignGitHubApiService.searchRepo(q);
    }

    @GetMapping(value = "/feign/baidu/api")
    public ResponseEntity<byte[]> baiduSearch(@RequestParam(value = "q") String q) {

        return feignBaiduService.searchRepo(q);
    }

}
