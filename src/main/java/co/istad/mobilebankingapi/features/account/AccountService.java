package co.istad.mobilebankingapi.features.account;


import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;

public interface AccountService {

    void createNew(AccountCreateRequest accountCreateRequest);

    AccountResponse findAccountByActNo(String actNo);

}
