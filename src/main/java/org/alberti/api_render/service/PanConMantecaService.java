package org.alberti.api_render.service;

import org.alberti.api_render.domain.Manteca;
import org.alberti.api_render.domain.Pan;
import org.alberti.api_render.domain.PanConManteca;
import org.alberti.api_render.repository.MantecaRepository;
import org.alberti.api_render.repository.PanConMantecaRepository;
import org.alberti.api_render.repository.PanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PanConMantecaService {

    private final PanConMantecaRepository panConMantecaRepository;
    private final PanRepository panRepository;
    private final MantecaRepository mantecaRepository;

    @Autowired
    public PanConMantecaService(
            PanConMantecaRepository panConMantecaRepository,
            PanRepository panRepository,
            MantecaRepository mantecaRepository
    ) {
        this.panConMantecaRepository = panConMantecaRepository;
        this.panRepository = panRepository;
        this.mantecaRepository = mantecaRepository;
    }

    public List<PanConManteca> getAllPanesConManteca() {
        return panConMantecaRepository.findAll();
    }

    public Optional<PanConManteca> getPanConMantecaById(Long id) {
        return panConMantecaRepository.findById(id);
    }

    public PanConManteca createPanConManteca(PanConManteca panConManteca, Long panId, Long mantecaId) {
        Pan pan = panRepository.findById(panId)
                .orElseThrow(() -> new RuntimeException("Pan no encontrado con id: " + panId));
        Manteca manteca = mantecaRepository.findById(mantecaId)
                .orElseThrow(() -> new RuntimeException("Manteca no encontrada con id: " + mantecaId));

        panConManteca.setPan(pan);
        panConManteca.setManteca(manteca);

        return panConMantecaRepository.save(panConManteca);
    }

    public PanConManteca updatePanConManteca(Long id, PanConManteca panConMantecaDetails, Long panId, Long mantecaId) {
        PanConManteca panConManteca = panConMantecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PanConManteca no encontrado con id: " + id));

        Pan pan = panRepository.findById(panId)
                .orElseThrow(() -> new RuntimeException("Pan no encontrado con id: " + panId));
        Manteca manteca = mantecaRepository.findById(mantecaId)
                .orElseThrow(() -> new RuntimeException("Manteca no encontrada con id: " + mantecaId));

        panConManteca.setNombre(panConMantecaDetails.getNombre());
        panConManteca.setDescripcion(panConMantecaDetails.getDescripcion());
        panConManteca.setStock(panConMantecaDetails.getStock());
        panConManteca.setPan(pan);
        panConManteca.setManteca(manteca);

        return panConMantecaRepository.save(panConManteca);
    }

    public void deletePanConManteca(Long id) {
        panConMantecaRepository.deleteById(id);
    }
}
