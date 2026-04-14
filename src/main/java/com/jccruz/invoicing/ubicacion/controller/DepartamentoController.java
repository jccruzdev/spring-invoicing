package com.jccruz.invoicing.ubicacion.controller;

import com.jccruz.invoicing.ubicacion.dto.Departamento;
import com.jccruz.invoicing.ubicacion.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @GetMapping("/{paisId}")
    public ResponseEntity<List<Departamento>> getMunicipio(@PathVariable int paisId){
        return ResponseEntity.ok(departamentoService.getDepartamentos(paisId));
    }

}
