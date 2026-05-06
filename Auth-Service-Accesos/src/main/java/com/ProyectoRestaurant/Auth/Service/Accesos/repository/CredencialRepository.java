package com.ProyectoRestaurant.Auth.Service.Accesos.repository;
import com.ProyectoRestaurant.Auth.Service.Accesos.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, String> {
    Optional<Credencial> findByTokenSesion(String tokenSesion);
    Optional<Credencial> findByUsername(String username);
}