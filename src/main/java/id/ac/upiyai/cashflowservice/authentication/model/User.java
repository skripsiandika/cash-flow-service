package id.ac.upiyai.cashflowservice.authentication.model;

import id.ac.upiyai.cashflowservice.util.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Email
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 13)
    private String phoneNumber;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "is_expired")
    private Boolean isExpired;

    @Column(name = "is_locked")
    private Boolean isLocked;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "is_credential_expired")
    private Boolean isCredentialsExpired;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleType")
    private RoleType roleType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
