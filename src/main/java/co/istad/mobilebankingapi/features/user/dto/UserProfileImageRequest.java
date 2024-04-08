package co.istad.mobilebankingapi.features.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public record UserProfileImageRequest(
        @NotBlank
        String mediaName
) {
}
