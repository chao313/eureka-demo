package demo.eureka.zuul.localController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localController")
public class Controller {

    @Component
    public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {
        private int serverPort;

        public int getServerPort() {
            return this.serverPort;
        }

        @Override
        public void onApplicationEvent(WebServerInitializedEvent event) {
            this.serverPort = event.getWebServer().getPort();
        }


    }

    @Autowired
    private ServerConfig serverConfig;

    @RequestMapping("/getPort")
    public int getPort() {
        return serverConfig.serverPort;
    }

    @RequestMapping("/getPort2")
    public int getPort2() {
        return serverConfig.serverPort;
    }
}
