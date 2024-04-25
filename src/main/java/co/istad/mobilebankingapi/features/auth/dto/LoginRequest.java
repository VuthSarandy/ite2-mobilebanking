package co.istad.mobilebankingapi.features.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Phone number is required")
        String phoneNumber,
        @NotBlank(message = "password is required")
        String password
) {
}
