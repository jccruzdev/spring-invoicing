package com.jccruz.invoicing.service;

import com.jccruz.invoicing.model.Tercero;
import com.jccruz.invoicing.repo.TerceroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerceroService {
    private final TerceroRepository terceroRepository;

    public List<Tercero> getActiveTerceros() {
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc();
    }

    public Page<Tercero> getActiveTercerosPageable(Pageable pageable){
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc(pageable);
    }

    public List<Tercero> getInactiveTerceros() {
        return terceroRepository.findByEstadoFalseOrderByFechaCreacionDesc();
    }
}
