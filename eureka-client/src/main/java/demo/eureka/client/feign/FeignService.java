//package demo.eureka.client.feign;
//
//import demo.eureka.client.EurekaClientApplication;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient(name = "github", url = "https://api.github.com", configuration = EurekaClientApplication.class)
//public interface FeignService {
//
//    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET)
//    String search(@RequestParam(value = "q") String q);
//}
