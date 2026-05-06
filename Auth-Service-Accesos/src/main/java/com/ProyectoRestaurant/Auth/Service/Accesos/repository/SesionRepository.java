package com.ProyectoRestaurant.Auth.Service.Accesos.repository;
import com.ProyectoRestaurant.Auth.Service.Accesos.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
}
