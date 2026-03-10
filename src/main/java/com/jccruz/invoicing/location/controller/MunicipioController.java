package com.jccruz.invoicing.location.controller;

import com.jccruz.invoicing.location.model.Municipio;
import com.jccruz.invoicing.location.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
@RequiredArgsConstructor
public class MunicipioController {

    private final MunicipioService municipioService;

    @GetMapping("/{departamentoId}")
    public ResponseEntity<List<Municipio>> getMunicipio(@PathVariable int departamentoId){
        return ResponseEntity.ok(municipioService.getMunicipios(departamentoId));
    }

}
