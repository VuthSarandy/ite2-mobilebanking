package co.istad.mobilebankingapi.features.account.dto;


import co.istad.mobilebankingapi.features.acounttype.dto.AccountTypeResponse;
import co.istad.mobilebankingapi.features.user.dto.UserDetailsResponse;

import java.math.BigDecimal;

public record AccountResponse(
        String alias,
        String actName,
        BigDecimal balance,
        BigDecimal transferLimit,
        AccountTypeResponse accountType,
        UserDetailsResponse user
) {
}
