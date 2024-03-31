package com.example.CRUD_Busqueda_con_filtros.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Debe ingresar un nombre")
    @Column(nullable=false, length=60)
    private String nombre;
    @NotBlank(message = "Debe ingresar una marca")
    @Column(nullable=false, length=60)
    private String marca;
    @NotBlank(message = "Debe ingresar un país de origen")
    @Column(nullable=false, length=60)
    private String hechoEn;
    @NotNull(message = "Debe ingresar un precio")
    @Column(nullable=false)
    private float precio;
}
