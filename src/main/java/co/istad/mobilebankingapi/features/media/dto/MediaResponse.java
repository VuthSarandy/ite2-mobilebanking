package co.istad.mobilebankingapi.features.media.dto;

import lombok.Builder;

@Builder
public record MediaResponse(
        String name, // Unique
        String contentType, // PNG, JPG, SVG, ...
        String extension,
        String uri, // Link to access
        Long size

) {
}
