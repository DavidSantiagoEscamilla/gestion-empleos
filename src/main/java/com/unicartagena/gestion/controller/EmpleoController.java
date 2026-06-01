package com.unicartagena.gestion.controller;

import com.unicartagena.gestion.model.Empleo;
import com.unicartagena.gestion.service.EmpleoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador MVC de Empleo (tabla asignada).
 * Implementa el CRUDL: Create, Read, Update, Delete y List.
 */
@Controller
@RequestMapping("/empleos")
public class EmpleoController {

    private final EmpleoService empleoService;

    public EmpleoController(EmpleoService empleoService) {
        this.empleoService = empleoService;
    }

    // LIST -> listado de empleos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleos", empleoService.listarTodos());
        return "empleos/lista";
    }

    // CREATE -> formulario vacio
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("empleo", new Empleo());
        return "empleos/formulario";
    }

    // UPDATE -> formulario con datos existentes
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Empleo empleo = empleoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de empleo invalido: " + id));
        model.addAttribute("empleo", empleo);
        return "empleos/formulario";
    }

    // CREATE / UPDATE -> guardar
    @PostMapping("/guardar")
    public String guardar(@Valid Empleo empleo, BindingResult result) {
        if (result.hasErrors()) {
            return "empleos/formulario";
        }
        empleoService.guardar(empleo);
        return "redirect:/empleos";
    }

    // DELETE -> eliminar por id
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        empleoService.eliminar(id);
        return "redirect:/empleos";
    }
}
