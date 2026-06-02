package com.unicartagena.gestion.service;

import com.unicartagena.gestion.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(String cedula);
    Usuario guardar(Usuario usuario);
    void eliminar(String cedula);
}
