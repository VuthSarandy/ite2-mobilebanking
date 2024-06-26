package co.istad.mobilebankingapi.features.account;


import co.istad.mobilebankingapi.features.account.dto.AccountCreateRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountRenameRequest;
import co.istad.mobilebankingapi.features.account.dto.AccountResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    Page<AccountResponse> findList(
            @RequestParam(required = false, defaultValue = "0") int page,
                @RequestParam(required = false, defaultValue = "25") int size
    ) {
        return accountService.findListAccount(page, size);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@Valid @RequestBody AccountCreateRequest accountCreateRequest){
        accountService.createNew(accountCreateRequest);
    }
//    @GetMapping
//    List<AccountResponse> findAll(){
//        return accountService.findListAccount();
//    }
    @PutMapping("/{actNo}/rename")
    AccountResponse renameService(@PathVariable String actNo,
                                  @Valid @RequestBody AccountRenameRequest accountRenameRequest){
        return accountService.renameByActNo(actNo,accountRenameRequest);
    }

    @PutMapping("/{actNo}/hide")
    void hideAccountByActNo(@PathVariable String actNo) {
        accountService.hideAccount(actNo);
    }


    @GetMapping("/{actNo}")
    AccountResponse findByActNo(@PathVariable String actNo) {
        return accountService.findByActNo(actNo);
    }
}