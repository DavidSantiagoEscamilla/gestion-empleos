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
 * Replica el modelo de las guias del profesor.
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // LIST
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }

    // CREATE - mostrar formulario
    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    // UPDATE - mostrar formulario con datos
    @GetMapping("/editar/{cedula}")
    public String editar(@PathVariable String cedula, Model model) {
        Usuario usuario = usuarioService.buscarPorId(cedula)
                .orElseThrow(() -> new IllegalArgumentException("Cedula invalida: " + cedula));
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    // CREATE / UPDATE - guardar
    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/formulario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // DELETE
    @GetMapping("/eliminar/{cedula}")
    public String eliminar(@PathVariable String cedula) {
        usuarioService.eliminar(cedula);
        return "redirect:/usuarios";
    }
}
