package com.jccruz.invoicing.parties.repository;

import com.jccruz.invoicing.parties.model.Tercero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerceroRepository extends JpaRepository<Tercero, Integer> {
    List<Tercero> findByEstadoTrueOrderByFechaCreacionDesc();
    Page<Tercero> findByEstadoTrueOrderByFechaCreacionDesc(Pageable pageable);
    List<Tercero> findByEstadoFalseOrderByFechaCreacionDesc();
}
