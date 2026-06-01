package com.unicartagena.gestion.repository;

import com.unicartagena.gestion.model.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa de acceso a datos (DAO) para Empleo.
 * Hereda todas las operaciones CRUD de JpaRepository.
 */
@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long> {
}
