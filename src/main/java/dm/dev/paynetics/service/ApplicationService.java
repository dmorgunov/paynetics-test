package dm.dev.paynetics.service;

import dm.dev.paynetics.client.PayneticsClient;
import dm.dev.paynetics.model.SubmitApplicationRequest;
import dm.dev.paynetics.model.SubmitApplicationResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final PayneticsClient payneticsClient;
    private final DeserializationService deserializationService;

    @SneakyThrows(IOException.class)
    public Mono<SubmitApplicationResponse> createApplication(String appName) {
        var request = deserializationService.deserialize("example.json", SubmitApplicationRequest.class);
        request.getCompany().setTradeName(appName);
        request.getCompany().setLegalName(appName);
        return payneticsClient.createApplication(request);
    }

}
