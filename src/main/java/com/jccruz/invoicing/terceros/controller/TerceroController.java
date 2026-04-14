package com.jccruz.invoicing.terceros.controller;

import com.jccruz.invoicing.handlers.exception_handler.exceptions.GeneralException;
import com.jccruz.invoicing.handlers.exception_handler.exceptions.ResourceNotFoundException;
import com.jccruz.invoicing.terceros.dto.*;
import com.jccruz.invoicing.terceros.service.TerceroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terceros")
@RequiredArgsConstructor
public class TerceroController {

    private final TerceroService terceroService;

    @GetMapping("/activos")
    public ResponseEntity<List<Tercero>> getActiveTerceros() {
        return ResponseEntity.ok(terceroService.getActiveTerceros());
    }

    @GetMapping("/activos/paginado")
    public ResponseEntity<Page<Tercero>> getActiveTercerosPaginado(Pageable pageable) {
        return ResponseEntity.ok(terceroService.getActiveTercerosPageable(pageable));
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Tercero>> getInactiveTerceros() {
        return ResponseEntity.ok(terceroService.getInactiveTerceros());
    }

    @PostMapping
    public ResponseEntity<Tercero> save(@RequestBody Tercero tercero) {
        Tercero savedTercero = terceroService.save(tercero);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTercero);
    }

    @PutMapping("/{terceroId}")
    public ResponseEntity<Tercero> update(@PathVariable Integer terceroId, @RequestBody Tercero tercero) {

        if (terceroId == null || terceroId < 0) {
            throw new GeneralException("Identificador de tercero no válido o no encontrado");
        }

        Tercero savedTercero = terceroService.update(terceroId, tercero);
        return ResponseEntity.ok(savedTercero);
    }

    @GetMapping("/tiposDocumento/{codigo}")
    public ResponseEntity<TiposDocumento> getTipoDocumentoByCodigo(@PathVariable String codigo) {

        TiposDocumento tipo = terceroService.findTipoDocumentoByCodigo(codigo);

        if (tipo == null) {
            throw new ResourceNotFoundException("Codigo '" + codigo + "' no encontrado");
        }

        return ResponseEntity.ok(tipo);
    }


    @GetMapping("/tiposImpuesto/{codigo}")
    public ResponseEntity<TiposImpuesto> getTipoImpuestoByCodigo(@PathVariable String codigo) {

        TiposImpuesto tipo = terceroService.findTipoImpuestoByCodigo(codigo);

        if (tipo == null) {
            throw new ResourceNotFoundException("Codigo '" + codigo + "' no encontrado");
        }

        return ResponseEntity.ok(tipo);
    }


    @GetMapping("/tiposOrganizacion/{codigo}")
    public ResponseEntity<TiposOrganizacion> getTipoOrganizacionByCodigo(@PathVariable String codigo) {

        TiposOrganizacion tipo = terceroService.findTipoOrganizacionByCodigo(codigo);

        if (tipo == null) {
            throw new ResourceNotFoundException("Codigo '" + codigo + "' no encontrado");
        }

        return ResponseEntity.ok(tipo);
    }


    @GetMapping("/tiposRegimen/{codigo}")
    public ResponseEntity<TiposRegimen> getTipoRegimenByCodigo(@PathVariable String codigo) {

        TiposRegimen tipo = terceroService.findTipoRegimenByCodigo(codigo);

        if (tipo == null) {
            throw new ResourceNotFoundException("Codigo '" + codigo + "' no encontrado");
        }

        return ResponseEntity.ok(tipo);
    }



    @GetMapping("/tiposResponsabilidad/{codigo}")
    public ResponseEntity<TiposResponsabilidad> getTipoResponsabilidadByCodigo(@PathVariable String codigo) {

        TiposResponsabilidad tipo = terceroService.findTipoResponsabilidadByCodigo(codigo);

        if (tipo == null) {
            throw new ResourceNotFoundException("Codigo '" + codigo + "' no encontrado");
        }

        return ResponseEntity.ok(tipo);
    }

}
