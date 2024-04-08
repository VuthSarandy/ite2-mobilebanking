package co.istad.mobilebankingapi.features.account;


import co.istad.mobilebankingapi.domain.Account;
import co.istad.mobilebankingapi.domain.AccountType;
import co.istad.mobilebankingapi.domain.User;
import co.istad.mobilebankingapi.domain.UserAccount;
import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import co.istad.mobilebankingapi.features.acounttype.AccountTypeRepository;
import co.istad.mobilebankingapi.features.acounttype.dto.AccountTypeResponse;
import co.istad.mobilebankingapi.features.user.UserRepository;
import co.istad.mobilebankingapi.features.user.dto.UserDetailsResponse;
import co.istad.mobilebankingapi.mapper.AccountMapper;
import co.istad.mobilebankingapi.mapper.AccountTypeMapper;
import co.istad.mobilebankingapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountTypeRepository accountTypeRepository;
    private final UserAccountRepository userAccountRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final AccountTypeMapper accountTypeMapper;


    @Override
    public void createNew(AccountCreateRequest accountCreateRequest) {

        AccountType accountType = accountTypeRepository.findByAliasIgnoreCase(accountCreateRequest.accountTypeAlias())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Invalid account type")
                );

        // check user by UUID
        User user = userRepository.findByUuid(accountCreateRequest.userUuid())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "User has not been found"));

        // map account dto to account entity
        Account account = accountMapper.fromAccountCreateRequest(accountCreateRequest);
        account.setAccountType(accountType);
        account.setActName(user.getName());
        account.setActNo("123456789");
        account.setTransferLimit(BigDecimal.valueOf(5000));
        account.setIsHidden(false);

        UserAccount userAccount = new UserAccount();
        userAccount.setAccount(account);
        userAccount.setUser(user);
        userAccount.setIsDeleted(false);
        userAccount.setIsBlocked(false);
        userAccount.setCreatedAt(LocalDateTime.now());

        userAccountRepository.save(userAccount);

    }

    @Override
    public AccountResponse findAccountByActNo(String actNo) {

        Account account = accountRepository.findByActNo(actNo);
        AccountTypeResponse accountTypeResponse = accountTypeMapper.toAccountTypeResponse(account.getAccountType());
        UserDetailsResponse userDetailsResponse = userMapper.toUserDetailResponse(account.getUserAccountList().get(0).getUser());

        return new AccountResponse(account.getAlias(),account.getActName(),account.getTransferLimit(),account.getBalance(),accountTypeResponse,userDetailsResponse);


    }


}