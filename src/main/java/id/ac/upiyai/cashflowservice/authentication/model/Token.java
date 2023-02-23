package id.ac.upiyai.cashflowservice.authentication.model;

import id.ac.upiyai.cashflowservice.util.TokenType;
import id.ac.upiyai.cashflowservice.util.audit.DateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tokens")
@Builder
public class Token extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "token_id", nullable = false)
    private Long tokenId;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
