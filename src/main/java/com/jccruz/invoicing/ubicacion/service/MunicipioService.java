package com.jccruz.invoicing.ubicacion.service;

import com.jccruz.invoicing.ubicacion.dto.Municipio;
import com.jccruz.invoicing.ubicacion.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public List<Municipio> getMunicipios(int departamentoId){
        return municipioRepository.findMunicipioByDepartamentoId(departamentoId);
    }
}
