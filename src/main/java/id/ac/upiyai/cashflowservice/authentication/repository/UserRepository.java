package id.ac.upiyai.cashflowservice.authentication.repository;

import id.ac.upiyai.cashflowservice.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
