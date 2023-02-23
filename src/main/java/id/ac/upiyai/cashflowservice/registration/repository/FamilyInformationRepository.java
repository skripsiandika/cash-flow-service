package id.ac.upiyai.cashflowservice.registration.repository;

import id.ac.upiyai.cashflowservice.registration.model.FamilyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyInformationRepository extends JpaRepository<FamilyInformation, Long> {
}
