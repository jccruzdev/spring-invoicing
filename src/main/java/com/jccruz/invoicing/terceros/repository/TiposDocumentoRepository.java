package com.jccruz.invoicing.terceros.repository;

import com.jccruz.invoicing.terceros.dto.TiposDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposDocumentoRepository extends JpaRepository<TiposDocumento, Integer> {
    TiposDocumento findByCodigo(String codigo);
}
