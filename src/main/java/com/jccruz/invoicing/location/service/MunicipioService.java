package com.jccruz.invoicing.location.service;

import com.jccruz.invoicing.location.model.Municipio;
import com.jccruz.invoicing.location.repository.MunicipioRepository;
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
