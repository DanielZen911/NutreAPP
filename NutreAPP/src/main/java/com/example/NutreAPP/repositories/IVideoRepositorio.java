package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Video;


@Repository
public interface IVideoRepositorio extends JpaRepository<Video, UUID> {


    // Para V5 al CREAR
    boolean existsByUrl(String url);

    // Para V5 al MODIFICAR (consulta 5)
    @Query("SELECT COUNT(v) FROM Video v WHERE v.url = :url AND v.id <> :id")
    long contarUrlEnOtroVideo(@Param("url") String url, @Param("id") UUID id);

    
    // buscar videos por categoria
    List<Video> findByCategoria(String categoria);

    // buscar videos por titulo (ignora mayúsculas/minúsculas)
    List<Video> findByTituloIgnoreCase(String titulo);

    // buscar videos cuya descripcion contenga un fragmento
    List<Video> findByDescripcionContainingIgnoreCase(String fragmento);

    // buscar videos por URL
    List<Video> findByUrl(String url);

    // buscar videos por titulo y categoria
    List<Video> findByTituloAndCategoria(String titulo, String categoria);
}