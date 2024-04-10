package co.istad.mobilebankingapi.features.account;


import co.istad.mobilebankingapi.domain.Account;
import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountRenameRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void createNew(AccountCreateRequest accountCreateRequest);
    AccountResponse findByActNo(String actNo);
    AccountResponse renameByActNo(String actNo, AccountRenameRequest accountRenameRequest);
    void hideAccount(String actNo);
    Page<AccountResponse> findListAccount(int size, int page);
    AccountResponse setLimitTransfer(String actNo, BigDecimal amount );
}
