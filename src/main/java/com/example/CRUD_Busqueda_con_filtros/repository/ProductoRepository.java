package com.example.CRUD_Busqueda_con_filtros.repository;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /*Query para obtener un producto con un determinado nombre*/
    @Query("SELECT producto FROM Producto producto WHERE "
            +"CONCAT(producto.id,producto.nombre,producto.marca,producto.hechoEn,producto.precio) "
            +"LIKE %?1%")
    public List<Producto> findAll(String palabraClave);
}
