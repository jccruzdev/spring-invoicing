package com.jccruz.invoicing.ubicacion.service;

import com.jccruz.invoicing.ubicacion.dto.Departamento;
import com.jccruz.invoicing.ubicacion.repository.DepartamentoRepository;
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
