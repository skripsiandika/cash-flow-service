package id.ac.upiyai.cashflowservice.disbursement.model;

import id.ac.upiyai.cashflowservice.registration.model.BusinessInformation;
import id.ac.upiyai.cashflowservice.util.audit.UserDateAudit;
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

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "disbursements")
public class Disbursement extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "disbursement_id", nullable = false)
    private Long disbursementId;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "total")
    private BigDecimal total;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "beneficiary_id", nullable = false)
    private BusinessInformation beneficiary;
}
