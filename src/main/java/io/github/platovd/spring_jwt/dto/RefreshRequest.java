package io.github.platovd.spring_jwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Запрос на обновление JWT")
public class RefreshRequest {
    @Schema(description = "Токен обновления")
    @Size(max = 150)
    private String refresh;
}
