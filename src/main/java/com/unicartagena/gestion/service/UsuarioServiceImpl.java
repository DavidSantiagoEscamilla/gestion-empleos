package com.unicartagena.gestion.service;

import com.unicartagena.gestion.model.Usuario;
import com.unicartagena.gestion.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarTodos() { return usuarioRepository.findAll(); }

    @Override
    public Optional<Usuario> buscarPorId(String cedula) { return usuarioRepository.findById(cedula); }

    @Override
    public Usuario guardar(Usuario usuario) { return usuarioRepository.save(usuario); }

    @Override
    public void eliminar(String cedula) { usuarioRepository.deleteById(cedula); }
}
