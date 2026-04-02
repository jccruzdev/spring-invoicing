package com.jccruz.invoicing.parties.service;

import com.jccruz.invoicing.handlers.exception_handler.events.DataIntegrityException;
import com.jccruz.invoicing.handlers.exception_handler.events.ResourceAlreadyExistsException;
import com.jccruz.invoicing.parties.model.Tercero;
import com.jccruz.invoicing.parties.repository.TerceroRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerceroService {

    private final TerceroRepository terceroRepository;
    private static final Logger log = LoggerFactory.getLogger(TerceroService.class);

    public List<Tercero> getActiveTerceros() {
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc();
    }

    public Page<Tercero> getActiveTercerosPageable(Pageable pageable){
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc(pageable);
    }

    public List<Tercero> getInactiveTerceros() {
        return terceroRepository.findByEstadoFalseOrderByFechaCreacionDesc();
    }

    public Tercero save(Tercero tercero){

        boolean existeTercero = terceroRepository.existsByNumeroIdentificacion(tercero.getNumeroIdentificacion());

        if(existeTercero){
           throw new ResourceAlreadyExistsException("El tercero ya está registrado");
        }

        try {
            return terceroRepository.save(tercero);
        }catch (DataIntegrityViolationException e){
            log.error("Error al guardar tercero {}", tercero.getNumeroIdentificacion(), e);
            throw new DataIntegrityException("No fue posible agregar el tercero, revise la información ingresada");
        }

        }
    }
