package org.alberti.api_render.web.mapper;

import org.alberti.api_render.domain.PanConManteca;
import org.alberti.api_render.web.dto.PanConMantecaRequestDTO;
import org.alberti.api_render.web.dto.PanConMantecaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PanConMantecaMapper {

    private final PanMapper panMapper;
    private final MantecaMapper mantecaMapper;

    @Autowired
    public PanConMantecaMapper(PanMapper panMapper, MantecaMapper mantecaMapper) {
        this.panMapper = panMapper;
        this.mantecaMapper = mantecaMapper;
    }

    public PanConManteca toEntity(PanConMantecaRequestDTO dto) {
        PanConManteca entity = new PanConManteca();
        entity.setNombre(dto.nombre());
        entity.setDescripcion(dto.descripcion());
        entity.setStock(dto.stock());
        return entity;
    }

    public PanConMantecaResponseDTO toResponseDTO(PanConManteca entity) {
        return new PanConMantecaResponseDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getStock(),
                entity.getPrecio(),
                panMapper.toResponseDTO(entity.getPan()),
                mantecaMapper.toResponseDTO(entity.getManteca())
        );
    }
}
