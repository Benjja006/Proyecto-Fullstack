package com.ProyectoRestaurant.inventory.Service.stock.service;

import com.ProyectoRestaurant.inventory.Service.stock.model.StockPlato;
import com.ProyectoRestaurant.inventory.Service.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepo;

    public boolean verificarStock(Long idPlato, Integer cantidadPedida) {
        return stockRepo.findByIdPlato(idPlato)
                .map(s -> s.getCantidadRestante() >= cantidadPedida && s.getDisponibleParaVenta())
                .orElse(false);
    }

    public void descontarStock(Long idPlato, Integer cantidad) {
        StockPlato stock = stockRepo.findByIdPlato(idPlato)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        stock.setCantidadRestante(stock.getCantidadRestante() - cantidad);
        if (stock.getCantidadRestante() <= 0) {
            stock.setDisponibleParaVenta(false);
        }
        stockRepo.save(stock);
    }

    public StockPlato actualizarStock(Long idPlato, Integer nuevaCantidad) {
        StockPlato stock = stockRepo.findByIdPlato(idPlato).orElse(new StockPlato());
        stock.setIdPlato(idPlato);
        stock.setCantidadRestante(nuevaCantidad);
        stock.setDisponibleParaVenta(nuevaCantidad > 0);
        return stockRepo.save(stock);
    }
}