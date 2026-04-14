package com.jccruz.invoicing.terceros.repository;

import com.jccruz.invoicing.terceros.dto.TiposResponsabilidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposResponsabilidadRepository extends JpaRepository<TiposResponsabilidad, Integer> {
    TiposResponsabilidad findByCodigo(String codigo);
}
