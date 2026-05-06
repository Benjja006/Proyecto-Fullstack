package com.ProyectoRestaurant.Auth.Service.Accesos.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "sesion")
@Data
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSesion;

    private Long idUsuario;
    private String rolUsuario;
    private LocalDateTime fechaInicio = LocalDateTime.now();
}
