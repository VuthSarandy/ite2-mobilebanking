package co.istad.mobilebankingapi.features.acounttype;


import co.istad.mobilebankingapi.domain.AccountType;
import co.istad.mobilebankingapi.features.acounttype.dto.AccountTypeResponse;
import co.istad.mobilebankingapi.mapper.AccountTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService{

    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeMapper accountTypeMapper;

    @Override
    public List<AccountTypeResponse> findAll() {

        List<AccountType> accountTypes = accountTypeRepository.findAll();

        return accountTypeMapper.toListAccountTypeResponse(accountTypes);
    }

    @Override
    public AccountTypeResponse findByAlias(String alias) {

        AccountType accountType = accountTypeRepository.findByAliasIgnoreCase(alias)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "account type does not exist!"
                ));

        return accountTypeMapper.toAccountTypeResponse(accountType);
    }
}
