package demo.eureka.client.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置Ribbon
 */
@Configuration
public class RibbonConfiguration {
    /**
     * @return
     * @Bean -> 注入 RestTemplate
     * @LoadBalanced -> 声明该 RestTemplate 用于负载
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 只需要添加一个配置类就能更改全局的策略设置
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
