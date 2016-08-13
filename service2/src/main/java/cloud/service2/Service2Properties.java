package cloud.service2;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Service2Properties {

    private String body = ", how are you?";

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
