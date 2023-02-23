package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.IdentityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "spouse_informations")
public class SpouseInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "spouse_information_id", nullable = false)
    private Long spouseInformationId;

    private String surname;

    private Date dateOfBirth;

    private String occupation;

    private IdentityType identityType;

    private String identityNumber;

    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_information_id", nullable = false)
    private FamilyInformation familyInformation;
}
