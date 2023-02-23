package id.ac.upiyai.cashflowservice.underwriting.repository;

import id.ac.upiyai.cashflowservice.underwriting.model.Worksheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorksheetRepository extends JpaRepository<Worksheet, UUID> {
}
