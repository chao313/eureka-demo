package demo.eureka.client.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

///**
// * 配置Ribbon
// * 当前配置指定为 RandomRule 随机策略
// *
// * @AvoidScan -> 用于避免扫描
// */
//@AvoidScan
//@Configuration
//public class RibbonRandomRuleConfiguration {
//
//    /**
//     * 只需要添加一个配置类就能更改全局的策略设置
//     *
//     * @return
//     */
//    @Bean
//    public IRule iRule() {
//        return new RandomRule();
//    }
//}
