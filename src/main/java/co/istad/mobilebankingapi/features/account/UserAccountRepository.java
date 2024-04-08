package co.istad.mobilebankingapi.features.account;


import co.istad.mobilebankingapi.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
