package com.jccruz.invoicing.terceros.repository;

import com.jccruz.invoicing.terceros.dto.TiposRegimen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposRegimenRepository extends JpaRepository<TiposRegimen, Integer> {
    TiposRegimen findByCodigo(String codigo);
}
