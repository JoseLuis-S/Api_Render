package org.alberti.api_render.repository;

import org.alberti.api_render.domain.PanConManteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanConMantecaRepository extends JpaRepository<PanConManteca, Long> {
}
