package id.ac.upiyai.cashflowservice.authentication.model.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignInRequest implements Serializable {

    @Email
    private String email;
    private String password;
}
