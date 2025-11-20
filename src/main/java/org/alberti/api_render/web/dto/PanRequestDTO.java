package org.alberti.api_render.web.dto;

import java.math.BigDecimal;

public record PanRequestDTO(
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer stock,
        String tipoHarina,
        Integer peso
) {
}
