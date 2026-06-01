package com.unicartagena.gestion.service;

import com.unicartagena.gestion.model.Empleo;
import com.unicartagena.gestion.repository.EmpleoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementacion de la logica de negocio de Empleo.
 */
@Service
public class EmpleoServiceImpl implements EmpleoService {

    private final EmpleoRepository empleoRepository;

    public EmpleoServiceImpl(EmpleoRepository empleoRepository) {
        this.empleoRepository = empleoRepository;
    }

    @Override
    public List<Empleo> listarTodos() {
        return empleoRepository.findAll();
    }

    @Override
    public Optional<Empleo> buscarPorId(Long id) {
        return empleoRepository.findById(id);
    }

    @Override
    public Empleo guardar(Empleo empleo) {
        return empleoRepository.save(empleo);
    }

    @Override
    public void eliminar(Long id) {
        empleoRepository.deleteById(id);
    }
}
