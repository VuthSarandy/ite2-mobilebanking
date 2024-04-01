package co.istad.mobilebankingapi.mapper;

import co.istad.mobilebankingapi.domain.AccountType;
import co.istad.mobilebankingapi.features.acounttype.dto.AccountTypeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {

    List<AccountTypeResponse> toListAccountTypeResponse(List<AccountType> accountTypes);

    AccountTypeResponse toAccountTypeResponse(AccountType accountType);

}
