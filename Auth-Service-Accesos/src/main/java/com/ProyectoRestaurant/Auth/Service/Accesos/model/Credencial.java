package com.ProyectoRestaurant.Auth.Service.Accesos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "credencial")
@Data
public class Credencial {
    @Id
    @NotBlank(message = "El username es obligatorio")
    private String username;

    @NotBlank(message = "El PIN es obligatorio")
    @Size(min = 4, max = 4, message = "El PIN debe ser de 4 dígitos")
    private String pinUsuario;

    private String tokenSesion;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long idUsuario;
}