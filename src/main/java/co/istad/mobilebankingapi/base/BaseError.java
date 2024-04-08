package co.istad.mobilebankingapi.base;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseError<T> {
    private String  code;
    private T description;
}
