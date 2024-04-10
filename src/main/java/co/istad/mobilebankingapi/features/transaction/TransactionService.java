package co.istad.mobilebankingapi.features.transaction;

import co.istad.mobilebankingapi.features.transaction.dto.TransactionCreateRequest;
import co.istad.mobilebankingapi.features.transaction.dto.TransactionResponse;

public interface TransactionService {

    TransactionResponse transfer(TransactionCreateRequest transactionCreateRequest);

}
