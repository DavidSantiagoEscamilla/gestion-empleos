package com.unicartagena.gestion.service;

import com.unicartagena.gestion.model.Empleo;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de la capa de Servicio para Empleo.
 */
public interface EmpleoService {

    List<Empleo> listarTodos();

    Optional<Empleo> buscarPorId(Long id);

    Empleo guardar(Empleo empleo);

    void eliminar(Long id);
}
