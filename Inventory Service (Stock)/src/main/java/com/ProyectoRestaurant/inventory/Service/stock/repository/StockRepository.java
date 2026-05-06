package com.ProyectoRestaurant.inventory.Service.stock.repository;

import com.ProyectoRestaurant.inventory.Service.stock.model.StockPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockPlato, Long> {
    Optional<StockPlato> findByIdPlato(Long idPlato);
}