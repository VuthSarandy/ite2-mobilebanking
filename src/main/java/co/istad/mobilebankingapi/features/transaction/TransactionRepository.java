package co.istad.mobilebankingapi.features.transaction;

import co.istad.mobilebankingapi.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
