package co.istad.mobilebankingapi.mapper;

import co.istad.mobilebankingapi.domain.Account;
import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import co.istad.mobilebankingapi.features.account.dto.AccountSnippetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        UserMapper.class,
        AccountTypeMapper.class
})
public interface AccountMapper {
    Account fromAccountCreateRequest(AccountCreateRequest accountCreateRequest);

    @Mapping(source = "userAccountList", target = "user",
            qualifiedByName = "mapUserDetailResponse")
    AccountResponse toAccountResponse(Account account);

    AccountSnippetResponse toAccountSnippetResponse(Account account);

    @Mapping(source = "userAccountList", target = "user",
            qualifiedByName = "mapUserDetailResponse")
    List<AccountResponse> toListAccountResponse(List<Account> accounts);

}
