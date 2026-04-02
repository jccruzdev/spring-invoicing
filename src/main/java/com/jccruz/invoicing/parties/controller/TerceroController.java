package com.jccruz.invoicing.parties.controller;

import com.jccruz.invoicing.parties.model.Tercero;
import com.jccruz.invoicing.parties.service.TerceroService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/terceros")
@RequiredArgsConstructor
public class  TerceroController {

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
    public ResponseEntity<Tercero> save(@RequestBody Tercero tercero){
            Tercero savedTercero = terceroService.save(tercero);

            return ResponseEntity
                    .created(URI.create("terceros/"+savedTercero.getId()))
                    .body(savedTercero);
    }

}
