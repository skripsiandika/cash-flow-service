package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.GenderType;
import id.ac.upiyai.cashflowservice.util.HomeOwnership;
import id.ac.upiyai.cashflowservice.util.IdentityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "personal_informations")
public class PersonalInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "personal_information_id", nullable = false)
    private Long personalInformationId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "other_name")
    private String otherName;

    @Column(name = "mother_name")
    private String motherName;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private IdentityType identityType;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private HomeOwnership residential;
}
