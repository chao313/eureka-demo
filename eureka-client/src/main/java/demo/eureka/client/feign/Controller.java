package demo.eureka.client.feign;

//import demo.eureka.client.feign.FeignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/feign")
public class Controller {

    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/feign/github/api")
    public String search(@RequestParam(value = "q") String q) {

        return feignService.searchRepo(q);
    }

}
