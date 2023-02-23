package id.ac.upiyai.cashflowservice.submission.model;

import id.ac.upiyai.cashflowservice.util.LoanPurpose;
import id.ac.upiyai.cashflowservice.util.audit.UserDateAudit;
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

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "submissions")
public class Submission extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "submission_id", nullable = false)
    private Long submissionId;

    @Column(name = "average_monthly_revenue", nullable = false)
    private BigDecimal avgMonthlyRevenue;

    @Column(name = "latest_revenue", nullable = false)
    private Date latestRevenue;

    @Column(name = "loan_amount", nullable = false)
    private BigDecimal loanAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "purpose")
    private LoanPurpose purpose;

    @Column(name = "loan_in_month", nullable = false)
    private Integer loanInMonth;
}
