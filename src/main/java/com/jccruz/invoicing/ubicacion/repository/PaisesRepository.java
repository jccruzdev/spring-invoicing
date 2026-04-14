package com.jccruz.invoicing.ubicacion.repository;

import com.jccruz.invoicing.ubicacion.dto.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesRepository extends JpaRepository<Pais,Integer> {
}
