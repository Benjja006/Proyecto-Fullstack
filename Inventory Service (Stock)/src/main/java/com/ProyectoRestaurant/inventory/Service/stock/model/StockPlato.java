package com.ProyectoRestaurant.inventory.Service.stock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_plato")
public class StockPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    private Long idPlato;
    private Boolean disponibleParaVenta;
    private Integer cantidadRestante;

    // Getters y Setters Manuales (Para evitar fallos de Lombok mañana)
    public Long getIdStock() { return idStock; }
    public void setIdStock(Long idStock) { this.idStock = idStock; }
    public Long getIdPlato() { return idPlato; }
    public void setIdPlato(Long idPlato) { this.idPlato = idPlato; }
    public Boolean getDisponibleParaVenta() { return disponibleParaVenta; }
    public void setDisponibleParaVenta(Boolean disponibleParaVenta) { this.disponibleParaVenta = disponibleParaVenta; }
    public Integer getCantidadRestante() { return cantidadRestante; }
    public void setCantidadRestante(Integer cantidadRestante) { this.cantidadRestante = cantidadRestante; }
}