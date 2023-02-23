package id.ac.upiyai.cashflowservice.authentication.repository;

import id.ac.upiyai.cashflowservice.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
