package id.ac.upiyai.cashflowservice.disbursement.repository;

import id.ac.upiyai.cashflowservice.disbursement.model.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {
}
