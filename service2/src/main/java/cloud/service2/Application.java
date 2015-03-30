package cloud.service2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties(Service2Properties.class)
@RestController
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Service1 service1;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Service2Properties service2Properties;

    @RequestMapping("/body/{name}")
    public String body(@PathVariable String name) {

        discoveryClient.getInstances("service1")
                .forEach(si -> logger.warn("service1 instance {}:{}", si.getHost(), si.getPort()));
        return service1.welcome(name) + service2Properties.getBody();
        //return restTemplate.getForObject("http://service1/welcome/{name}", String.class, name) + body;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
