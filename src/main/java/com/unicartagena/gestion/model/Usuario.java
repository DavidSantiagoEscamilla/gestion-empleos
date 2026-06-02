package com.unicartagena.gestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Entidad Usuario -> tabla "usuarios".
 * Replica EXACTA del modelo de las guias del profesor.
 * Campos: cedula (PK), clave, nombre, email.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(nullable = false)
    private String cedula;

    @NotBlank(message = "La clave es obligatoria")
    @Column(nullable = false)
    private String clave;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @Email(message = "El email no tiene un formato valido")
    @Column
    private String email;

    // ---- Constructores ----
    public Usuario() {
    }

    public Usuario(String cedula, String clave, String nombre, String email) {
        this.cedula = cedula;
        this.clave = clave;
        this.nombre = nombre;
        this.email = email;
    }

    // ---- Getters y Setters ----
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
