package cloud.service2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service1")
public interface Service1 {
    @RequestMapping(method = RequestMethod.GET, value = "/welcome/{name}")
    String welcome(@PathVariable("name") String name);
}
