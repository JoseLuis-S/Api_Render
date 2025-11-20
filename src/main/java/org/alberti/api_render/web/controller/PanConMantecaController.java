package org.alberti.api_render.web.controller;

import org.alberti.api_render.domain.PanConManteca;
import org.alberti.api_render.web.dto.PanConMantecaRequestDTO;
import org.alberti.api_render.web.dto.PanConMantecaResponseDTO;
import org.alberti.api_render.web.mapper.PanConMantecaMapper;
import org.alberti.api_render.service.PanConMantecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/panes-con-manteca")
public class PanConMantecaController {

    private final PanConMantecaService panConMantecaService;
    private final PanConMantecaMapper panConMantecaMapper;

    @Autowired
    public PanConMantecaController(PanConMantecaService panConMantecaService, PanConMantecaMapper panConMantecaMapper) {
        this.panConMantecaService = panConMantecaService;
        this.panConMantecaMapper = panConMantecaMapper;
    }

    @GetMapping
    public List<PanConMantecaResponseDTO> getAllPanesConManteca() {
        return panConMantecaService.getAllPanesConManteca().stream()
                .map(panConMantecaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanConMantecaResponseDTO> getPanConMantecaById(@PathVariable Long id) {
        return panConMantecaService.getPanConMantecaById(id)
                .map(panConMantecaMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PanConMantecaResponseDTO createPanConManteca(@RequestBody PanConMantecaRequestDTO requestDTO) {
        PanConManteca panConManteca = panConMantecaMapper.toEntity(requestDTO);
        PanConManteca created = panConMantecaService.createPanConManteca(
                panConManteca,
                requestDTO.panId(),
                requestDTO.mantecaId()
        );
        return panConMantecaMapper.toResponseDTO(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanConMantecaResponseDTO> updatePanConManteca(
            @PathVariable Long id,
            @RequestBody PanConMantecaRequestDTO requestDTO
    ) {
        PanConManteca panConMantecaDetails = panConMantecaMapper.toEntity(requestDTO);
        PanConManteca updated = panConMantecaService.updatePanConManteca(
                id,
                panConMantecaDetails,
                requestDTO.panId(),
                requestDTO.mantecaId()
        );
        return ResponseEntity.ok(panConMantecaMapper.toResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanConManteca(@PathVariable Long id) {
        panConMantecaService.deletePanConManteca(id);
        return ResponseEntity.noContent().build();
    }
}
