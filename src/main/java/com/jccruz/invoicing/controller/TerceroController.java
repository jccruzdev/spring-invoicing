package com.jccruz.invoicing.controller;

import com.jccruz.invoicing.model.Tercero;
import com.jccruz.invoicing.service.TerceroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
