package com.jccruz.invoicing.location.service;

import com.jccruz.invoicing.location.model.Departamento;
import com.jccruz.invoicing.location.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public List<Departamento> getDepartamentos(int paisId){
        return departamentoRepository.findDepartamentoByPaisId(paisId);
    }
}
