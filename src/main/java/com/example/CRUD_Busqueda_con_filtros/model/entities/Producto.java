package com.example.CRUD_Busqueda_con_filtros.model.entities;

import jakarta.persistence.*;
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
    @Column(nullable=false, length=60)
    private String nombre;
    @Column(nullable=false, length=60)
    private String marca;
    @Column(nullable=false, length=60)
    private String hechoEn;
    @Column(nullable=false)
    private float precio;
}
