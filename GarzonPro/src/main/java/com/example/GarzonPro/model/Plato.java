package com.example.GarzonPro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "platos")
@Data
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlato;

    @NotBlank(message = "El nombre del plato no puede estar vacío")
    private String nombrePlato;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    // Relación: Un plato pertenece a una categoría
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria idCategoria;
}