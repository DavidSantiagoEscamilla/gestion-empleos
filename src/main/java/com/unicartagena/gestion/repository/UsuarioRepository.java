package com.unicartagena.gestion.repository;

import com.unicartagena.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos para Usuario.
 * La clave primaria es String (cedula).
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
