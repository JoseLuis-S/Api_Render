package org.alberti.api_render.web.controller;

import org.alberti.api_render.domain.Pan;
import org.alberti.api_render.web.dto.PanRequestDTO;
import org.alberti.api_render.web.dto.PanResponseDTO;
import org.alberti.api_render.web.mapper.PanMapper;
import org.alberti.api_render.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/panes")
public class PanController {

    private final PanService panService;
    private final PanMapper panMapper;

    @Autowired
    public PanController(PanService panService, PanMapper panMapper) {
        this.panService = panService;
        this.panMapper = panMapper;
    }

    @GetMapping
    public List<PanResponseDTO> getAllPanes() {
        return panService.getAllPanes().stream()
                .map(panMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanResponseDTO> getPanById(@PathVariable Long id) {
        return panService.getPanById(id)
                .map(panMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PanResponseDTO createPan(@RequestBody PanRequestDTO panRequestDTO) {
        Pan pan = panMapper.toEntity(panRequestDTO);
        Pan createdPan = panService.createPan(pan);
        return panMapper.toResponseDTO(createdPan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanResponseDTO> updatePan(@PathVariable Long id, @RequestBody PanRequestDTO panRequestDTO) {
        Pan panDetails = panMapper.toEntity(panRequestDTO);
        Pan updatedPan = panService.updatePan(id, panDetails);
        return ResponseEntity.ok(panMapper.toResponseDTO(updatedPan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePan(@PathVariable Long id) {
        panService.deletePan(id);
        return ResponseEntity.noContent().build();
    }
}
