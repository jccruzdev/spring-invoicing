package com.jccruz.invoicing.location.controller;

import com.jccruz.invoicing.location.model.Pais;
import com.jccruz.invoicing.location.service.PaisesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/paises")
@RequiredArgsConstructor
public class PaisesController {

    private final PaisesService paisesService;

    @GetMapping
    public ResponseEntity<List<Pais>> getPaises(){
        return ResponseEntity.ok(paisesService.getPaises()) ;
    }

}
