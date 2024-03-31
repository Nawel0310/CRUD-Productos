package com.example.CRUD_Busqueda_con_filtros.controller;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;
import com.example.CRUD_Busqueda_con_filtros.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @RequestMapping("/")
    public String verPaginaInicio(Model modelo){
        List<Producto> listaProductos=productoService.listarProductos();
        modelo.addAttribute("listaProductos",listaProductos);
        return "index.html";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioDeProducto(Model modelo){
        Producto producto= new Producto();
        modelo.addAttribute("producto",producto);
        return "agregar";
    }

    @RequestMapping(value="/guardar",method = RequestMethod.POST)
    public String guardarFormularioDeProducto(@ModelAttribute("producto") Producto producto){
        productoService.guardarProducto(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model modelo){
        Producto producto= productoService.obtenerProductoPorId(id);
        modelo.addAttribute("producto",producto);
        return "agregar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String actualizarProducto(@PathVariable Long id, Producto producto, Model modelo){
        Producto productoBD=productoService.obtenerProductoPorId(id);

        productoBD.setMarca(producto.getMarca());
        productoBD.setNombre(producto.getNombre());
        productoBD.setPrecio(producto.getPrecio());
        productoBD.setHechoEn(producto.getHechoEn());

        productoService.guardarProducto(productoBD);
        return "redirect:/";
    }
}
