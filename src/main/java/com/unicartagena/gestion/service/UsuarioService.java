package com.unicartagena.gestion.service;

import com.unicartagena.gestion.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de la capa de Servicio para Usuario.
 * Define la logica de negocio que usara el controlador.
 */
public interface UsuarioService {

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorId(Long id);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);
}
