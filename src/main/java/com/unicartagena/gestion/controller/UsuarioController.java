package com.unicartagena.gestion.controller;

import com.unicartagena.gestion.model.Usuario;
import com.unicartagena.gestion.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador MVC de Usuario.
 * Gestiona las rutas del CRUD y devuelve las vistas Thymeleaf.
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // READ / LIST -> lista de usuarios
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    // CREATE -> mostrar formulario vacio
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    // UPDATE -> mostrar formulario con datos existentes
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuario invalido: " + id));
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    // CREATE / UPDATE -> guardar (mismo metodo para crear y editar)
    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            // Si hay errores de validacion, regresa al formulario
            return "usuarios/formulario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // DELETE -> eliminar por id
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}
