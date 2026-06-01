package com.unicartagena.gestion.repository;

import com.unicartagena.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos (DAO) para Usuario.
 * Al extender JpaRepository ya hereda save(), findAll(),
 * findById(), deleteById(), etc. sin escribir SQL.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
