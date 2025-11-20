package org.alberti.api_render.web.controller;

import org.alberti.api_render.domain.Manteca;
import org.alberti.api_render.web.dto.MantecaRequestDTO;
import org.alberti.api_render.web.dto.MantecaResponseDTO;
import org.alberti.api_render.web.mapper.MantecaMapper;
import org.alberti.api_render.service.MantecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mantecas")
public class MantecaController {

    private final MantecaService mantecaService;
    private final MantecaMapper mantecaMapper;

    @Autowired
    public MantecaController(MantecaService mantecaService, MantecaMapper mantecaMapper) {
        this.mantecaService = mantecaService;
        this.mantecaMapper = mantecaMapper;
    }

    @GetMapping
    public List<MantecaResponseDTO> getAllMantecas() {
        return mantecaService.getAllMantecas().stream()
                .map(mantecaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantecaResponseDTO> getMantecaById(@PathVariable Long id) {
        return mantecaService.getMantecaById(id)
                .map(mantecaMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MantecaResponseDTO createManteca(@RequestBody MantecaRequestDTO mantecaRequestDTO) {
        Manteca manteca = mantecaMapper.toEntity(mantecaRequestDTO);
        Manteca createdManteca = mantecaService.createManteca(manteca);
        return mantecaMapper.toResponseDTO(createdManteca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantecaResponseDTO> updateManteca(@PathVariable Long id, @RequestBody MantecaRequestDTO mantecaRequestDTO) {
        Manteca mantecaDetails = mantecaMapper.toEntity(mantecaRequestDTO);
        Manteca updatedManteca = mantecaService.updateManteca(id, mantecaDetails);
        return ResponseEntity.ok(mantecaMapper.toResponseDTO(updatedManteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManteca(@PathVariable Long id) {
        mantecaService.deleteManteca(id);
        return ResponseEntity.noContent().build();
    }
}
