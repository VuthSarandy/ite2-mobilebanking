package co.istad.mobilebankingapi.features.media.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record MediaResponse(
        String name, // Unique
        String contentType, // PNG, JPG, SVG, ...
        String extension,
        String uri, // Link to access
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long size

) {
}
