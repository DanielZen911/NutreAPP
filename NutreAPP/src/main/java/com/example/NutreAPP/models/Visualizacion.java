package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;

public class Visualizacion {

    private UUID id;
    private LocalDate fecha_vizualizacion;
    private Boolean completado;

    public Visualizacion() {
    }
    
    public Visualizacion(UUID id, LocalDate fecha_vizualizacion, Boolean completado) {
        this.id = id;
        this.fecha_vizualizacion = fecha_vizualizacion;
        this.completado = completado;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDate getFecha_vizualizacion() {
        return fecha_vizualizacion;
    }
    public void setFecha_vizualizacion(LocalDate fecha_vizualizacion) {
        this.fecha_vizualizacion = fecha_vizualizacion;
    }
    public Boolean getCompletado() {
        return completado;
    }
    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    




    
}
