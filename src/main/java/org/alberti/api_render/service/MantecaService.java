package org.alberti.api_render.service;

import org.alberti.api_render.domain.Manteca;
import org.alberti.api_render.repository.MantecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MantecaService {

    private final MantecaRepository mantecaRepository;

    @Autowired
    public MantecaService(MantecaRepository mantecaRepository) {
        this.mantecaRepository = mantecaRepository;
    }

    public List<Manteca> getAllMantecas() {
        return mantecaRepository.findAll();
    }

    public Optional<Manteca> getMantecaById(Long id) {
        return mantecaRepository.findById(id);
    }

    public Manteca createManteca(Manteca manteca) {
        return mantecaRepository.save(manteca);
    }

    public Manteca updateManteca(Long id, Manteca mantecaDetails) {
        Manteca manteca = mantecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manteca no encontrada con id: " + id));

        manteca.setTipoManteca(mantecaDetails.getTipoManteca());
        manteca.setDescripcion(mantecaDetails.getDescripcion());
        manteca.setPrecio(mantecaDetails.getPrecio());

        return mantecaRepository.save(manteca);
    }

    public void deleteManteca(Long id) {
        mantecaRepository.deleteById(id);
    }
}
