package co.istad.mobilebankingapi.mapper;


import co.istad.mobilebankingapi.domain.Transaction;
import co.istad.mobilebankingapi.features.transaction.dto.TransactionCreateRequest;
import co.istad.mobilebankingapi.features.transaction.dto.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface TransactionMapper {

    TransactionResponse toTransactionResponse(Transaction transaction);

    Transaction fromTransactionCreateRequest(TransactionCreateRequest transactionCreateRequest);

}

