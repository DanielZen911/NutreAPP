package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Visualizacion {

   @Id 
    private UUID id;
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "fecha_visualizacion", nullable = false, unique = false)
    private LocalDate fecha_visualizacion;

    @Column(name = "completado", nullable = false, unique = false)
    private Boolean completado;

    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fecha_vizualizacion, Boolean completado) {
        this.id = id;
        this.fecha_visualizacion = fecha_vizualizacion;
        this.completado = completado;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDate getFecha_vizualizacion() {
        return fecha_visualizacion;
    }
    public void setFecha_vizualizacion(LocalDate fecha_vizualizacion) {
        this.fecha_visualizacion = fecha_vizualizacion;
    }
    public Boolean getCompletado() {
        return completado;
    }
    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    




    
}
