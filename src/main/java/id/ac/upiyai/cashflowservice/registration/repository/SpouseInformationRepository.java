package id.ac.upiyai.cashflowservice.registration.repository;

import id.ac.upiyai.cashflowservice.registration.model.SpouseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpouseInformationRepository extends JpaRepository<SpouseInformation, Long> {
}
