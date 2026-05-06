package com.ProyectoRestaurant.inventory.Service.stock.controller;

import com.ProyectoRestaurant.inventory.Service.stock.model.StockPlato;
import com.ProyectoRestaurant.inventory.Service.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/check/{idPlato}/{cantidad}")
    public boolean check(@PathVariable Long idPlato, @PathVariable Integer cantidad) {
        return stockService.verificarStock(idPlato, cantidad);
    }

    @PostMapping("/update")
    public StockPlato update(@RequestBody StockPlato stock) {
        return stockService.actualizarStock(stock.getIdPlato(), stock.getCantidadRestante());
    }
}