package cloud.service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Value("${format}")
    String format;

    @RequestMapping("/welcome/{name}")
    public String welcomeMessage(@PathVariable String name) {
        logger.warn("welcome called");
        return String.format(format, name);
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
