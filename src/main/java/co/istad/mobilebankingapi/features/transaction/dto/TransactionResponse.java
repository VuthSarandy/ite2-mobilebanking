package co.istad.mobilebankingapi.features.transaction.dto;

import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import co.istad.mobilebankingapi.features.account.dto.AccountSnippetResponse;

import java.time.LocalDateTime;

public record TransactionResponse(
        AccountSnippetResponse owner,
        AccountSnippetResponse transferReceiver,
        String remark,
        String transactionType,
        Boolean status,
        LocalDateTime transactionAt
) {
}
