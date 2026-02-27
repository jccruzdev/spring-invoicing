package com.jccruz.invoicing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "terceros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tercero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_organizacion_id", nullable = false)
    private Integer tipoOrganizacionId;

    @Column(name = "tipo_documento_id", nullable = false)
    private Integer tipoDocumentoId;

    @Column(name = "pais_id", nullable = false)
    private Integer paisId;

    @Column(name = "departamento_id", nullable = false)
    private Integer departamentoId;

    @Column(name = "municipio_id", nullable = false)
    private Integer municipioId;

    @Column(name = "tipo_regimen_id", nullable = false)
    private Integer tipoRegimenId;

    @Column(name = "tipo_impuesto_id", nullable = false)
    private Integer tipoImpuestoId;

    @Column(name = "tipo_responsabilidad_id", nullable = false)
    private Integer tipoResponsabilidadId;

    @Column(name = "numero_identificacion", nullable = false, length = 30)
    private String numeroIdentificacion;

    @Column(name = "dv", length = 2)
    private String dv;

    @Column(name = "nombre_razon_social", nullable = false, length = 150)
    private String nombreRazonSocial;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 30)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
}
