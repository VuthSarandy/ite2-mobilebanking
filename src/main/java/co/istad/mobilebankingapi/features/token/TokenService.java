package co.istad.mobilebankingapi.features.token;

import co.istad.mobilebankingapi.features.auth.dto.AuthResponse;
import org.springframework.security.core.Authentication;

public interface TokenService {

    AuthResponse createToken(Authentication auth);

    String createAccessToken(Authentication auth);

    String createRefreshToken(Authentication auth);

}

