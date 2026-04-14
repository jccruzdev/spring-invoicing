package com.jccruz.invoicing.terceros.service;

import com.jccruz.invoicing.handlers.exception_handler.exceptions.DataIntegrityException;
import com.jccruz.invoicing.handlers.exception_handler.exceptions.GeneralException;
import com.jccruz.invoicing.handlers.exception_handler.exceptions.ResourceAlreadyExistsException;
import com.jccruz.invoicing.handlers.exception_handler.exceptions.ResourceNotFoundException;
import com.jccruz.invoicing.terceros.dto.*;
import com.jccruz.invoicing.terceros.repository.*;
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
    private final TiposDocumentoRepository tiposDocumentoRepository;
    private final TiposImpuestoRepository tiposImpuestoRepository;
    private final TiposOrganizacionRepository tiposOrganizacionRepository;
    private final TiposRegimenRepository tiposRegimenRepository;
    private final TiposResponsabilidadRepository tiposResponsabilidadRepository;

    private static final Logger log = LoggerFactory.getLogger(TerceroService.class);

    public List<Tercero> getActiveTerceros() {
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc();
    }

    public Page<Tercero> getActiveTercerosPageable(Pageable pageable) {
        return terceroRepository.findByEstadoTrueOrderByFechaCreacionDesc(pageable);
    }

    public List<Tercero> getInactiveTerceros() {
        return terceroRepository.findByEstadoFalseOrderByFechaCreacionDesc();
    }

    public Tercero save(Tercero tercero) {
        boolean existeTercero = terceroRepository.existsByNumeroIdentificacion(tercero.getNumeroIdentificacion());

        if (existeTercero) {
            throw new ResourceAlreadyExistsException("El tercero ya está registrado [numeroIdentificacion]");
        }

        try {
            return terceroRepository.save(tercero);
        } catch (DataIntegrityViolationException e) {
            log.error("Error al guardar tercero {}", tercero.getNumeroIdentificacion(), e);
            throw new DataIntegrityException("No fue posible agregar el tercero, revise la información ingresada");
        } catch (Exception e) {
            throw new GeneralException("Error al insertar el tercero, no superó las validaciones");
        }

    }

    public Tercero update(Integer terceroId, Tercero request) {

        //validar existencia tercero actualizar
        Tercero tercero = terceroRepository.findById(terceroId).orElseThrow(() -> new ResourceNotFoundException("Tercero no encontrado en la base de datos"));

        tercero.setTipoOrganizacionId(request.getTipoOrganizacionId());
        tercero.setTipoDocumentoId(request.getTipoDocumentoId());
        tercero.setPaisId(request.getPaisId());
        tercero.setDepartamentoId(request.getDepartamentoId());
        tercero.setMunicipioId(request.getMunicipioId());
        tercero.setTipoRegimenId(request.getTipoRegimenId());
        tercero.setTipoImpuestoId(request.getTipoImpuestoId());
        tercero.setTipoResponsabilidadId(request.getTipoResponsabilidadId());
        tercero.setNumeroIdentificacion(request.getNumeroIdentificacion());
        tercero.setDv(request.getDv());
        tercero.setNombreRazonSocial(request.getNombreRazonSocial());
        tercero.setCorreo(request.getCorreo());
        tercero.setTelefono(request.getTelefono());
        tercero.setDireccion(request.getDireccion());

        try {
            return terceroRepository.save(tercero);
        } catch (Exception e) {
            throw new GeneralException("Error al ACTUALIZAR el tercero, no superó las validaciones");
        }
    }


    public TiposDocumento findTipoDocumentoByCodigo(String codigo) {
        return tiposDocumentoRepository.findByCodigo(codigo);
    }

    public TiposImpuesto findTipoImpuestoByCodigo(String codigo) {
        return tiposImpuestoRepository.findByCodigo(codigo);
    }

    public TiposOrganizacion findTipoOrganizacionByCodigo(String codigo) {
        return tiposOrganizacionRepository.findByCodigo(codigo);
    }

    public TiposRegimen findTipoRegimenByCodigo(String codigo) {
        return tiposRegimenRepository.findByCodigo(codigo);
    }

    public TiposResponsabilidad findTipoResponsabilidadByCodigo(String codigo) {
        return tiposResponsabilidadRepository.findByCodigo(codigo);
    }

}
