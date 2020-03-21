package demo.eureka.provider.controller.hystrix.cache;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * HystrixCache的配置
 */
@Configuration
public class HystrixCacheConfiguration {

    @Bean
    @ConditionalOnClass(Controller.class)
    public CacheContextInterceptor userContextInterceptor() {
        return new CacheContextInterceptor();
    }

    /**
     * 配置MVC 配置器
     */
    @Configuration
    @ConditionalOnClass(Controller.class)
    public class WebMvcConfig extends WebMvcConfigurerAdapter {
        @Autowired
        CacheContextInterceptor userContextInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(userContextInterceptor);
        }
    }


    /**
     * 请求拦截器
     * --在请求的开始初始化 Hystrix的上下文
     * --在请求的结束shutdown Hystrix的上下文
     */
    public class CacheContextInterceptor implements HandlerInterceptor {

        private HystrixRequestContext context;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) throws Exception {
            context = HystrixRequestContext.initializeContext();
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2, ModelAndView arg3)
                throws Exception {
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
                throws Exception {
            context.shutdown();
        }

    }
}
