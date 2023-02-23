package id.ac.upiyai.cashflowservice.registration.model.request;

import id.ac.upiyai.cashflowservice.util.GenderType;
import id.ac.upiyai.cashflowservice.util.HomeOwnership;
import id.ac.upiyai.cashflowservice.util.IdentityType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RegistrationRequest implements Serializable {

    private String fullName;
    private GenderType gender;
    private String spouseName;
    private String spouseOccupation;
    private String birthPlace;
    private Date dateOfBirth;
    private IdentityType identityType;
    private String identityNumber;
    private String address;
    private String phoneNumber;
    private HomeOwnership residential;
}
