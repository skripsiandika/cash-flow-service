package id.ac.upiyai.cashflowservice.registration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "document_requirements")
public class DocumentRequirement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "document_requirement_id", nullable = false)
    private Long documentRequirementId;

    @Column(name = "document_name")
    private String documentName;

    @ManyToOne
    @JoinColumn(name="registration_id", nullable=false)
    private Registration registration;
}
