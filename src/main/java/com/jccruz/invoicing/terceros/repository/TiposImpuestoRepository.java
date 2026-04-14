package com.jccruz.invoicing.terceros.repository;

import com.jccruz.invoicing.terceros.dto.TiposImpuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposImpuestoRepository extends JpaRepository<TiposImpuesto, Integer> {
    TiposImpuesto findByCodigo(String codigo);
}
