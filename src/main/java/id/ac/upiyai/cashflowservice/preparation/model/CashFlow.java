package id.ac.upiyai.cashflowservice.preparation.model;

import id.ac.upiyai.cashflowservice.util.CashFlowType;
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

@Getter
@Setter
@Entity
@Table(name = "cash_flows")
public class CashFlow extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cash_flow_id", nullable = false)
    private Long cashFlowId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "credit")
    private BigDecimal credit;

    @Column(name = "debt")
    private BigDecimal debt;

    @Column(name = "month", length = 2, nullable = false)
    private String month;

    @Column(name = "year", length = 4, nullable = false)
    private String year;

    @Enumerated(EnumType.STRING)
    private CashFlowType cashFlowType;
}
