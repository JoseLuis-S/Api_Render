package org.alberti.api_render.repository;

import org.alberti.api_render.domain.Manteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantecaRepository extends JpaRepository<Manteca, Long> {
}
