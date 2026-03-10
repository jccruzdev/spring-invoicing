package com.jccruz.invoicing.location.repository;

import com.jccruz.invoicing.location.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {
    List<Departamento> findDepartamentoByPaisId(int paisId);
}
