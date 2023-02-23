package id.ac.upiyai.cashflowservice.authentication.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class AuthorizationResponse implements Serializable {
    private String token;
}
