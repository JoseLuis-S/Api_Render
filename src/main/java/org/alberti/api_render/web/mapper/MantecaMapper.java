package org.alberti.api_render.web.mapper;

import org.alberti.api_render.domain.Manteca;
import org.alberti.api_render.web.dto.MantecaRequestDTO;
import org.alberti.api_render.web.dto.MantecaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MantecaMapper {

    public Manteca toEntity(MantecaRequestDTO dto) {
        return new Manteca(
                dto.tipoManteca(),
                dto.descripcion(),
                dto.precio()
        );
    }

    public MantecaResponseDTO toResponseDTO(Manteca entity) {
        return new MantecaResponseDTO(
                entity.getId(),
                entity.getTipoManteca(),
                entity.getDescripcion(),
                entity.getPrecio()
        );
    }
}
