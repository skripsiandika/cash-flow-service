package id.ac.upiyai.cashflowservice.registration.repository;

import id.ac.upiyai.cashflowservice.registration.model.DocumentRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRequirementRepository extends JpaRepository<DocumentRequirement, Long> {
}
