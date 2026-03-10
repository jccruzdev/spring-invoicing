package com.jccruz.invoicing.location.service;

import com.jccruz.invoicing.location.model.Pais;
import com.jccruz.invoicing.location.repository.PaisesRepository;
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
