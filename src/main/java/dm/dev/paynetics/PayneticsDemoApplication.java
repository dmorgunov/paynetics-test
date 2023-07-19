package dm.dev.paynetics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class PayneticsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayneticsDemoApplication.class, args);
    }

}
