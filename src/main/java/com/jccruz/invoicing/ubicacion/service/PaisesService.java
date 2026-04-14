package com.jccruz.invoicing.ubicacion.service;

import com.jccruz.invoicing.ubicacion.dto.Pais;
import com.jccruz.invoicing.ubicacion.repository.PaisesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisesService {

    private final PaisesRepository paisesRepository;

    public List<Pais> getPaises(){
        return paisesRepository.findAll();
    }
}
