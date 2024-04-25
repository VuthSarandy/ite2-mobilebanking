package co.istad.mobilebankingapi.features.auth.dto;

public record AuthResponse(
        String type,
        String accessToken,
        String refreshToken
) {
}
