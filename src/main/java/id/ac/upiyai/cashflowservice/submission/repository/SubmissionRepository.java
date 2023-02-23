package id.ac.upiyai.cashflowservice.submission.repository;

import id.ac.upiyai.cashflowservice.submission.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
