package com.example.NutreAPP.validations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Component
public class VideoValidacion {

    @Autowired
    private IVideoRepositorio repositorio;

    // V1. Titulo obligatorio y entre 5 y 120 caracteres -> 400
    public void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El título es obligatorio.");
        }
        int longitud = titulo.trim().length();
        if (longitud < 5 || longitud > 120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El título debe tener entre 5 y 120 caracteres.");
        }
    }

    // V2. La URL es obligatoria y debe empezar por "http://" o "https://" -> 400
    public void validarUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La URL es obligatoria.");
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La URL debe empezar por http:// o https://.");
        }
    }

    // V3. La categoria es obligatoria (no puede llegar null) -> 400
    public void validarCategoria(Object categoria) {
        if (categoria == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La categoría es obligatoria.");
        }
    }

    // V4. La descripcion es opcional, pero si viene no puede superar 500 caracteres -> 400
    public void validarDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() > 500) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La descripción no puede superar los 500 caracteres.");
        }
    }

    // V5 (CREAR). No pueden existir dos videos con la misma URL -> 409
    public void validarUrlUnicaCrear(String url) {
        if (this.repositorio.existsByUrl(url)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un video registrado con esa URL.");
        }
    }

    // V5 (MODIFICAR). No pueden existir dos videos con la misma URL -> 409
    public void validarUrlUnicaModificar(String url, UUID id) {
        if (this.repositorio.contarUrlEnOtroVideo(url, id) > 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe otro video registrado con esa URL.");
        }
    }
}