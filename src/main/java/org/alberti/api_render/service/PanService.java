package org.alberti.api_render.service;

import org.alberti.api_render.domain.Pan;
import org.alberti.api_render.repository.PanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PanService {

    private final PanRepository panRepository;

    @Autowired
    public PanService(PanRepository panRepository) {
        this.panRepository = panRepository;
    }

    public List<Pan> getAllPanes() {
        return panRepository.findAll();
    }

    public Optional<Pan> getPanById(Long id) {
        return panRepository.findById(id);
    }

    public Pan createPan(Pan pan) {
        return panRepository.save(pan);
    }

    public Pan updatePan(Long id, Pan panDetails) {
        Pan pan = panRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pan no encontrado con id: " + id));

        pan.setNombre(panDetails.getNombre());
        pan.setDescripcion(panDetails.getDescripcion());
        pan.setPrecio(panDetails.getPrecio());
        pan.setStock(panDetails.getStock());
        pan.setTipoHarina(panDetails.getTipoHarina());
        pan.setPeso(panDetails.getPeso());

        return panRepository.save(pan);
    }

    public void deletePan(Long id) {
        panRepository.deleteById(id);
    }
}
