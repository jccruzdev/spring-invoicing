package com.jccruz.invoicing.location.repository;

import com.jccruz.invoicing.location.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesRepository extends JpaRepository<Pais,Integer> {
}
