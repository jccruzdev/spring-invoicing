package com.jccruz.invoicing.location.controller;

import com.jccruz.invoicing.location.model.Departamento;
import com.jccruz.invoicing.location.service.DepartamentoService;
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
