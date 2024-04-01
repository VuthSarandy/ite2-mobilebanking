package co.istad.mobilebankingapi.features.acounttype;


import co.istad.mobilebankingapi.features.acounttype.dto.AccountTypeResponse;

import java.util.List;

public interface AccountTypeService {

    List<AccountTypeResponse> findAll();

    AccountTypeResponse findByAlias(String alias);
}
