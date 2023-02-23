package id.ac.upiyai.cashflowservice.registration.repository;

import id.ac.upiyai.cashflowservice.registration.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {
}
