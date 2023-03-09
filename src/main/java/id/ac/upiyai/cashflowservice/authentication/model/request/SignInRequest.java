package id.ac.upiyai.cashflowservice.authentication.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignInRequest implements Serializable {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;
}
