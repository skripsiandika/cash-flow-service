package id.ac.upiyai.cashflowservice.authentication.repository;

import id.ac.upiyai.cashflowservice.authentication.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
    @Query(value = """
      select t from Token t inner join User u on t.user.userId = u.userId where u.userId =:userId and (t.expired = false or t.revoked = false)
      """)
    List<Token> findAllValidTokenByUser(Long userId);
}
