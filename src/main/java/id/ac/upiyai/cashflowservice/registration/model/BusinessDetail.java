package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.HomeOwnership;
import io.swagger.v3.oas.annotations.Hidden;
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
@Table(name = "business_details")
@Hidden
public class BusinessDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "business_detail_id", nullable = false)
    private Long businessDetailId;

    private String businessSector;

    private String businessProduct;

    @Enumerated(EnumType.STRING)
    private HomeOwnership businessResidential;

    private Integer employeeNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_information_id", nullable = false)
    private BusinessInformation businessInformation;
}
