package id.ac.upiyai.cashflowservice.authentication;

import id.ac.upiyai.cashflowservice.authentication.model.Role;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthorizationResponse register(SignUpRequest request) {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName(RoleType.SME);
        roles.add(role);
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setIsExpired(true);
        user.setIsLocked(true);
        user.setIsEnabled(true);
        user.setIsCredentialsExpired(true);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);

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
