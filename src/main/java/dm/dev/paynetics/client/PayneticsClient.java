package dm.dev.paynetics.client;

import dm.dev.paynetics.model.SubmitApplicationRequest;
import dm.dev.paynetics.model.SubmitApplicationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "paynetics", url = "${feign.client.urls.paynetics}")
public interface PayneticsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/v3/applications", headers = "X-Operation=application_create")
    Mono<SubmitApplicationResponse> createApplication(SubmitApplicationRequest req);

}
