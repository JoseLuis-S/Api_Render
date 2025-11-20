package org.alberti.api_render.repository;

import org.alberti.api_render.domain.Pan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanRepository extends JpaRepository<Pan, Long> {
}
