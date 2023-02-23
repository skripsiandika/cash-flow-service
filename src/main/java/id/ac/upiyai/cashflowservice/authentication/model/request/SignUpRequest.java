package id.ac.upiyai.cashflowservice.authentication.model.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignUpRequest implements Serializable {
    private String username;
    @Email
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
}
