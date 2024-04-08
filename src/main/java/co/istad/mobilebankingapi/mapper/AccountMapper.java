package co.istad.mobilebankingapi.mapper;

import co.istad.mobilebankingapi.domain.Account;
import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account fromAccountCreateRequest(AccountCreateRequest accountCreateRequest);

    AccountResponse toAccountResponse(Account account);

}
