# Sistema de Gestion - Spring Boot MVC

Aplicacion web desarrollada con **Spring Boot** siguiendo la arquitectura **MVC (Modelo-Vista-Controlador)**.
Incluye el **CRUD de Usuarios** (replicando las guias) y el **CRUDL de Empleos** (tabla asignada).

Universidad de Cartagena - Facultad de Ingenieria - Ingenieria de Software.

---

## Tecnologias

- Java 17
- Spring Boot 3.2.5 (Spring MVC, Spring Data JPA)
- Thymeleaf (motor de plantillas)
- MySQL 8
- Maven

---

## Arquitectura por capas

```
com.unicartagena.gestion
├── model/         <- Entidades JPA (Usuario, Empleo)
├── repository/    <- Acceso a datos (JpaRepository)
├── service/       <- Logica de negocio (interfaz + implementacion)
└── controller/    <- Controladores MVC (rutas HTTP)

resources
├── templates/     <- Vistas Thymeleaf (HTML)
├── static/css/    <- Estilos
└── application.properties
```

---

## Como ejecutar

1. Tener instalado Java 17 y MySQL.
2. Crear la base de datos:
   ```sql
   CREATE DATABASE gestion_empleos;
   ```
3. Ajustar usuario y contrasena en `src/main/resources/application.properties`.
4. Ejecutar la aplicacion (cualquiera de las dos opciones):
   - **Desde el IDE** (recomendado): importar como proyecto Maven en IntelliJ IDEA, Eclipse o Spring Tool Suite y ejecutar la clase `GestionEmpleosApplication`. El IDE descarga las dependencias y genera el wrapper automaticamente.
   - **Desde la terminal** (si tiene Maven instalado): `mvn spring-boot:run`
5. Abrir en el navegador: `http://localhost:8080`

Las tablas `usuarios` y `empleos` se crean automaticamente (ddl-auto=update).

---

## Rutas principales

| Modulo   | Listar          | Crear                 | Editar                      | Eliminar                      |
|----------|-----------------|-----------------------|-----------------------------|-------------------------------|
| Usuarios | `/usuarios`     | `/usuarios/nuevo`     | `/usuarios/editar/{id}`     | `/usuarios/eliminar/{id}`     |
| Empleos  | `/empleos`      | `/empleos/nuevo`      | `/empleos/editar/{id}`      | `/empleos/eliminar/{id}`      |

---

## Autor

David Santiago Escamilla Castro
