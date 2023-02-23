package id.ac.upiyai.cashflowservice.registration.model;

import id.ac.upiyai.cashflowservice.util.RegistrationProcess;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "registration_steps")
public class RegistrationStep implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "registration_step_id", nullable = false)
    private Long registrationStepId;

    @Column(name = "registration_order")
    private Integer registrationStepOrder;

    private RegistrationProcess process;

    @OneToMany(mappedBy="step")
    private Set<Registration> registrations;
}
