package org.alberti.api_render.web.dto;

public record PanConMantecaRequestDTO(
        String nombre,
        String descripcion,
        Integer stock,
        Long panId,
        Long mantecaId
) {
}
