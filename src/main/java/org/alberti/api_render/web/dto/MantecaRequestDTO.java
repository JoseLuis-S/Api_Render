package org.alberti.api_render.web.dto;

import java.math.BigDecimal;

public record MantecaRequestDTO(
        String tipoManteca,
        String descripcion,
        BigDecimal precio
) {
}
