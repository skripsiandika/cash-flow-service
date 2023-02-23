package id.ac.upiyai.cashflowservice.registration.repository;

import id.ac.upiyai.cashflowservice.registration.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
