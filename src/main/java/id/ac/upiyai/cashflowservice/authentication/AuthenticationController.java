package id.ac.upiyai.cashflowservice.authentication;

import id.ac.upiyai.cashflowservice.authentication.model.request.SignInRequest;
import id.ac.upiyai.cashflowservice.authentication.model.request.SignUpRequest;
import id.ac.upiyai.cashflowservice.authentication.model.response.AuthorizationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthorizationResponse> signUp(@Valid @RequestBody SignUpRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> signIn(@Valid @RequestBody SignInRequest request) {
        return new ResponseEntity<>(service.authenticate(request), HttpStatus.OK);
    }
}
