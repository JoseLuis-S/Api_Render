package org.alberti.api_render.web.dto;

import java.math.BigDecimal;

public record PanConMantecaResponseDTO(
        Long id,
        String nombre,
        String descripcion,
        Integer stock,
        BigDecimal precio,
        PanResponseDTO pan,
        MantecaResponseDTO manteca
) {
}
