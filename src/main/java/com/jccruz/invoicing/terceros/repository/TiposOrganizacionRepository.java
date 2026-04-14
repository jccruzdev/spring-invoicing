package com.jccruz.invoicing.terceros.repository;

import com.jccruz.invoicing.terceros.dto.TiposOrganizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposOrganizacionRepository extends JpaRepository<TiposOrganizacion, Integer> {
    TiposOrganizacion findByCodigo(String codigo);
}
