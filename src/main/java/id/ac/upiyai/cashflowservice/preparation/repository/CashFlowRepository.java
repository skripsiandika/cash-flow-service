package id.ac.upiyai.cashflowservice.preparation.repository;

import id.ac.upiyai.cashflowservice.preparation.model.CashFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashFlowRepository extends JpaRepository<CashFlow, Long> {
}
