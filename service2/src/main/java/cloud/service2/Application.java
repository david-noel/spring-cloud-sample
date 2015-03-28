package cloud.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class Application {

    @Autowired
    private Service1 service1;

    String body = ", This is the body content";

    @RequestMapping("/body/{name}")
    public String body(@PathVariable String name) {
        return service1.welcome(name) + body;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
