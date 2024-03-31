package com.example.CRUD_Busqueda_con_filtros.repository;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
