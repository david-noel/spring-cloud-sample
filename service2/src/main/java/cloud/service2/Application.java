package cloud.service2;

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

    String body = ", This is the body content";

    @RequestMapping("/body/{name}")
    public String body(@PathVariable String name) {
        // call remote service
        return body;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
