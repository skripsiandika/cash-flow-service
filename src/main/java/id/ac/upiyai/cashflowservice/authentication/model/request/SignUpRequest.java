package id.ac.upiyai.cashflowservice.authentication.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignUpRequest implements Serializable {
    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String firstName;
    private String lastName;

    @NotNull
    private String password;
}
