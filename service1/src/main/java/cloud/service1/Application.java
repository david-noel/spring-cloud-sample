package cloud.service1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

    @Value("${format}")
    String format = "Welcome %s!";

    @RequestMapping("/welcome/{name}")
    public String welcomeMessage(@PathVariable String name) {
        return String.format(format, name);
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
