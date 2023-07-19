package dm.dev.paynetics.controller;

import dm.dev.paynetics.model.SubmitApplicationRequest;
import dm.dev.paynetics.model.SubmitApplicationResponse;
import dm.dev.paynetics.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("")
    public ResponseEntity<Mono<SubmitApplicationResponse>> createApplication(@RequestParam String appName){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(applicationService.createApplication(appName));
    }


}
