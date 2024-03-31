package com.example.CRUD_Busqueda_con_filtros.service;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> listarProductos();
    public Producto guardarProducto (Producto producto);
    public Producto obtenerProductoPorId(Long id);
    public Producto actualizarProducto(Producto producto);
    public void eliminarProducto (Long id);
}
