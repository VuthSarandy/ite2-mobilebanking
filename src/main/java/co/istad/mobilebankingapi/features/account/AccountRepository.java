package co.istad.mobilebankingapi.features.account;

import co.istad.mobilebankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByActNo(String actNo);

}
