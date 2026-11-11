package com.example.NutreAPP.models;

import java.util.UUID;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

public class Video {

    private UUID id;
    private String titulo;
    private String descripcion;
    private String url;
    private Categorization capacitacion_interna;

}
