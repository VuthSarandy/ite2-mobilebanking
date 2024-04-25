package co.istad.mobilebankingapi.features.auth;

import co.istad.mobilebankingapi.features.auth.dto.AuthResponse;
import co.istad.mobilebankingapi.features.auth.dto.LoginRequest;
import co.istad.mobilebankingapi.features.auth.dto.RefreshTokenRequest;

public interface AuthService {

    AuthResponse refresh(RefreshTokenRequest refreshTokenRequest);

    AuthResponse login(LoginRequest loginRequest);

}

