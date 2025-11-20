package org.alberti.api_render.web.dto;

import java.math.BigDecimal;

public record PanResponseDTO(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer stock,
        String tipoHarina,
        Integer peso
) {
}
