package com.unicartagena.gestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * Entidad Empleo -> tabla "empleos".
 * Esta es la tabla ASIGNADA. Sigue el mismo modelo que la entidad Usuario.
 *
 * Campos: nombre, categoria, areaTrabajo, empresa, nivel, sueldo, funciones, cargoJefe.
 */
@Entity
@Table(name = "empleos")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del empleo es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La categoria es obligatoria")
    @Column(nullable = false)
    private String categoria;

    @NotBlank(message = "El area de trabajo es obligatoria")
    @Column(name = "area_trabajo", nullable = false)
    private String areaTrabajo;

    @NotBlank(message = "La empresa es obligatoria")
    @Column(nullable = false)
    private String empresa;

    @NotBlank(message = "El nivel es obligatorio")
    @Column(nullable = false)
    private String nivel;

    @NotNull(message = "El sueldo es obligatorio")
    @PositiveOrZero(message = "El sueldo no puede ser negativo")
    @Column(nullable = false)
    private Double sueldo;

    @NotBlank(message = "Las funciones son obligatorias")
    @Column(columnDefinition = "TEXT")
    private String funciones;

    @NotBlank(message = "El cargo del jefe es obligatorio")
    @Column(name = "cargo_jefe", nullable = false)
    private String cargoJefe;

    // ---- Constructores ----
    public Empleo() {
    }

    public Empleo(String nombre, String categoria, String areaTrabajo, String empresa,
                  String nivel, Double sueldo, String funciones, String cargoJefe) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.areaTrabajo = areaTrabajo;
        this.empresa = empresa;
        this.nivel = nivel;
        this.sueldo = sueldo;
        this.funciones = funciones;
        this.cargoJefe = cargoJefe;
    }

    // ---- Getters y Setters ----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getCargoJefe() {
        return cargoJefe;
    }

    public void setCargoJefe(String cargoJefe) {
        this.cargoJefe = cargoJefe;
    }
}
