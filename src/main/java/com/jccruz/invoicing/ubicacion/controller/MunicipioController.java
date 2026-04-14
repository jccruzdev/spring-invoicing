package com.jccruz.invoicing.ubicacion.controller;

import com.jccruz.invoicing.ubicacion.dto.Municipio;
import com.jccruz.invoicing.ubicacion.service.MunicipioService;
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
