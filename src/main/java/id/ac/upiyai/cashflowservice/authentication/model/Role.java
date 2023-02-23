package id.ac.upiyai.cashflowservice.authentication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;
}
