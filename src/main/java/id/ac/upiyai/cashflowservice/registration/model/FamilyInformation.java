package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.MaritalStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Getter
@Setter
@Entity
@Table(name = "family_informations")
public class FamilyInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "family_information_id", nullable = false)
    private Long familyInformationId;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "dependents", nullable = false)
    private Integer dependents;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "familyInformation")
    private SpouseInformation spouseInformation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registration_id", nullable = false)
    private Registration registration;
}
