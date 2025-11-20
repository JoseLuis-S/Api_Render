package org.alberti.api_render.web.mapper;

import org.alberti.api_render.domain.Pan;
import org.alberti.api_render.web.dto.PanRequestDTO;
import org.alberti.api_render.web.dto.PanResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PanMapper {

    public Pan toEntity(PanRequestDTO dto) {
        return new Pan(
                dto.nombre(),
                dto.descripcion(),
                dto.precio(),
                dto.stock(),
                dto.tipoHarina(),
                dto.peso()
        );
    }

    public PanResponseDTO toResponseDTO(Pan entity) {
        return new PanResponseDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getStock(),
                entity.getTipoHarina(),
                entity.getPeso()
        );
    }
}
