package org.alberti.api_render.web.dto;

import java.math.BigDecimal;

public record MantecaResponseDTO(
        Long id,
        String tipoManteca,
        String descripcion,
        BigDecimal precio
) {
}
