package com.example.CRUD_Busqueda_con_filtros.service.impl;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;
import com.example.CRUD_Busqueda_con_filtros.repository.ProductoRepository;
import com.example.CRUD_Busqueda_con_filtros.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> listarProductos(String palabraClave) {
        if (palabraClave != null){
            return productoRepository.findAll(palabraClave);
        }
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
