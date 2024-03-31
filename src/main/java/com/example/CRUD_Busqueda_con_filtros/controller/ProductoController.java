package com.example.CRUD_Busqueda_con_filtros.controller;

import com.example.CRUD_Busqueda_con_filtros.model.entities.Producto;
import com.example.CRUD_Busqueda_con_filtros.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @RequestMapping({"/",""})
    public String verPaginaInicio(Model modelo){
        List<Producto> listaProductos=productoService.listarProductos();
        modelo.addAttribute("listaProductos",listaProductos);
        return "index.html";
    }
    @GetMapping("/nuevo")
    public String mostrarFormularioDeIngreso(Model modelo){
        modelo.addAttribute("producto",new Producto());
        return "agregar";
    }

    @PostMapping("/nuevo")
    public String guardarDatosDeRegistro(@Validated Producto producto, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("producto",producto);
            return "agregar";
        }
        productoService.guardarProducto(producto);
        redirect.addFlashAttribute("msgExito","El producto se ha agregado correctamente.");
        return "redirect:/";
    }

    @PostMapping("/borrar/{id}")
    public String borrarProducto(@PathVariable Long id, RedirectAttributes redirect) {
        productoService.eliminarProducto(id);
        redirect.addFlashAttribute("msgExito","El producto ha sido borrado.");
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model){
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto",producto);
        return "agregar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable Long id, @Validated Producto producto, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        Producto productoDB= productoService.obtenerProductoPorId(id);

        if (bindingResult.hasErrors()){
            model.addAttribute("producto",productoDB);
            return "agregar";
        }

        productoDB.setMarca(producto.getMarca());
        productoDB.setNombre(producto.getNombre());
        productoDB.setPrecio(producto.getPrecio());
        productoDB.setHechoEn(producto.getHechoEn());

        productoService.guardarProducto(productoDB);

        redirect.addFlashAttribute("msgExito","El producto se ha actualizado");
        return "redirect:/";
    }




}
