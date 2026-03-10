package com.jccruz.invoicing.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_dian", nullable = false, unique = true)
    private String codigoDian;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "pais_id", nullable = false)
    private int paisId;
}
