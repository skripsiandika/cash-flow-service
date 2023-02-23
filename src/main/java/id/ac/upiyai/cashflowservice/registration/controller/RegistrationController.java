package id.ac.upiyai.cashflowservice.registration.controller;

import id.ac.upiyai.cashflowservice.registration.model.request.RegistrationRequest;
import id.ac.upiyai.cashflowservice.registration.model.response.RegistrationResponse;
import id.ac.upiyai.cashflowservice.registration.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping
    public ResponseEntity<RegistrationResponse> register(@Valid @RequestBody RegistrationRequest request) {
        RegistrationResponse response = service.registerBasicInfo(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
