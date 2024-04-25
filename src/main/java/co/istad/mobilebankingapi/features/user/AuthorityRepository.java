package co.istad.mobilebankingapi.features.user;

import co.istad.mobilebankingapi.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
