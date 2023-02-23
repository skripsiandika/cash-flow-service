package id.ac.upiyai.cashflowservice.authentication;

import id.ac.upiyai.cashflowservice.authentication.model.Token;
import id.ac.upiyai.cashflowservice.authentication.model.User;
import id.ac.upiyai.cashflowservice.authentication.model.request.SignInRequest;
import id.ac.upiyai.cashflowservice.authentication.model.request.SignUpRequest;
import id.ac.upiyai.cashflowservice.authentication.model.response.AuthorizationResponse;
import id.ac.upiyai.cashflowservice.authentication.repository.TokenRepository;
import id.ac.upiyai.cashflowservice.authentication.repository.UserRepository;
import id.ac.upiyai.cashflowservice.security.JwtService;
import id.ac.upiyai.cashflowservice.util.RoleType;
import id.ac.upiyai.cashflowservice.util.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthorizationResponse register(SignUpRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roleType(RoleType.SME)
                .build();

        User savedUser = repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthorizationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthorizationResponse authenticate(SignInRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthorizationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}
