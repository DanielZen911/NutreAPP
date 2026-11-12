package com.example.NutreAPP.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Video {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo", nullable = false, unique = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, unique = false, length = 100)
    private String descripcion;

    @Column(name = "url", nullable = false, unique = false, length = 100)
    private String url;

    @Enumerated 
    @Column(name = "capacitacion_interna", nullable = false, unique = false, length = 100)
    private Categorization capacitacion_interna;

    @OneToMany(mappedBy="video")
    @JsonManagedReference (value = "video-visualizacion")
    private Usuario usuario;
    private List<Visualizacion> visualisaciones;

    public Video() {
    }

    public Video(UUID id, String titulo, String descripcion, String url, Categorization capacitacion_interna) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.capacitacion_interna = capacitacion_interna;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Categorization getCapacitacion_interna() {
        return capacitacion_interna;
    }

    public void setCapacitacion_interna(Categorization capacitacion_interna) {
        this.capacitacion_interna = capacitacion_interna;
    }

    

}
