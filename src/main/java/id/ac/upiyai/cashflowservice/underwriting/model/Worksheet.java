package id.ac.upiyai.cashflowservice.underwriting.model;

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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "worksheets")
public class Worksheet extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "worksheet_id", nullable = false)
    private Long worksheetId;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "beginning_balance", nullable = false)
    private BigDecimal beginningBalance;

    @Column(name = "ending_balance", nullable = false)
    private BigDecimal endingBalance;

    @Column(name = "interest", nullable = false)
    private BigDecimal interest;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sme_id", nullable = false)
    private BusinessInformation sme;

}
