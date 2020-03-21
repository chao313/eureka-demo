package demo.eureka.client;

import demo.eureka.client.config.ribbon.AvoidScan;
//import demo.eureka.client.config.ribbon.RibbonRandomRuleConfiguration;
//import demo.eureka.client.config.ribbon.RibbonRoundRobinRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@RibbonClients(value = {
//        @RibbonClient(name = "provider2", configuration = RibbonRandomRuleConfiguration.class),//不同的源 - 配置不同的ribbon策略
//        @RibbonClient(name = "provider", configuration = RibbonRoundRobinRuleConfiguration.class)}
//)
/**
 * 使用 @AvoidScan 来排除扫描( Ribbon 的配置)
 */
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}