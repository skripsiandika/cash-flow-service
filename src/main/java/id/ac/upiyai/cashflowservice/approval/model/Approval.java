package id.ac.upiyai.cashflowservice.approval.model;

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

@Getter
@Setter
@Entity
@Table(name = "approvals")
public class Approval extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "approval_id", nullable = false)
    private Long approvalId;

    private String approvedBy;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "debtor_id", nullable = false)
    private BusinessInformation debtor;


}
