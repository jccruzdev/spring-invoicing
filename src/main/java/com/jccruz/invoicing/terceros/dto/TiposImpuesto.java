package com.jccruz.invoicing.terceros.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "tercero_tipos_impuesto")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TiposImpuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private String nombre;
}
