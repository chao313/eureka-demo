package demo.eureka.client.config.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置Ribbon 的 RestTemplate
 *
 * @AvoidScan -> 用于避免扫描
 */
@Configuration
public class RibbonLoadBalancedConfiguration {
    /**
     * @Bean -> 注入 RestTemplate
     * @LoadBalanced -> 声明该 RestTemplate 用于负载
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
