package com.jccruz.invoicing.location.repository;

import com.jccruz.invoicing.location.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Integer> {
    public List<Municipio> findMunicipioByDepartamentoId(int departamento_id);
}
