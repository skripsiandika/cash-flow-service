package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.audit.UserDateAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "registrations")
public class Registration extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "registration_id", nullable = false)
    private Long registrationId;

    @Column(name = "average_monthly_revenue", nullable = false)
    private BigDecimal avgMonthlyRevenue;

    @Column(name = "latest_revenue", nullable = false)
    private Date latestRevenue;

    @OneToMany(mappedBy="registration")
    private Set<DocumentRequirement> documents;

    @ManyToOne
    @JoinColumn(name="registration_step_id", nullable=false)
    private RegistrationStep step;

    @OneToOne(cascade =  CascadeType.ALL,
            mappedBy = "registration")
    private FamilyInformation familyInformation;

    @OneToOne(cascade =  CascadeType.ALL,
            mappedBy = "registration")
    private BusinessInformation businessInformation;
}
