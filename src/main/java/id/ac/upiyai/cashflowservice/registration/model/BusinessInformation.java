package id.ac.upiyai.cashflowservice.registration.model;

import jakarta.persistence.CascadeType;
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
@Getter
@Setter
@Entity
@Table(name = "business_informations")
public class BusinessInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "business_information_id", nullable = false)
    private Long businessInformationId;

    @Column(name = "name")
    private String businessName;

    @Column(name = "address")
    private String businessAddress;

    @Column(name = "email")
    private String businessEmail;

    @Column(name = "phone_number")
    private String businessPhoneNumber;

    @Column(name = "whatsapp_number")
    private String businessWhatsappNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registration_id", nullable = false)
    private Registration registration;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private PersonalInformation personalInformation;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "businessInformation")
    private BusinessDetail businessDetail;
}
