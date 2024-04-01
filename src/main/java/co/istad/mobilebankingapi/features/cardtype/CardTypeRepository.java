package co.istad.mobilebankingapi.features.cardtype;

import co.istad.mobilebankingapi.domain.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType,Integer> {

    Optional<CardType> findByNameIgnoreCase(String name);
}
