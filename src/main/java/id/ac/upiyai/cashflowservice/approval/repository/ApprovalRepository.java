package id.ac.upiyai.cashflowservice.approval.repository;

import id.ac.upiyai.cashflowservice.approval.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Long> {
}
