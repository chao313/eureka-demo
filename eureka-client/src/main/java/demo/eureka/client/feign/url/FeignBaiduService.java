package demo.eureka.client.feign.url;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "baidu", url = "https://www.baidu.com", configuration = FeignServiceConfig.class)
public interface FeignBaiduService {

    /**
     * @param queryStr
     * @return
     */
    @RequestMapping(value = "/s", method = RequestMethod.GET)
    ResponseEntity<byte[]> searchRepo(@RequestParam("q") String queryStr);

}