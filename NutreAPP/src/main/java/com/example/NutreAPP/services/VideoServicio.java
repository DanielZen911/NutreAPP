package com.example.NutreAPP.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

public class VideoServicio {

    @Autowired
    private IVideoRepositorio repositorio;

    public Video guardar(Video datos){
        return this.repositorio.save(datos);
    }

        //Metodo para buscar po Id
    public Video buscarPorId(UUID id){
        Optional<Video> videoBusacado = this.repositorio.findById(id);
        if(!videoBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return videoBuscado.get();
        }
    }

    //Metodo para buscar todos
    public List<Video> buscarTodos(){
        return this.repositorio.findAll();
    }

        //Metodo para actualizar (modificar)
    public Video modificar(UUID id, Video datos){
        if(!videoBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{

            //1. RECARGAR LA INFO QUE EXISTE ACTUALMENTE EN BD
            video videoEncontrado=videoBuscado.get();

            //2. Espacio para modificar solo las propiedades permitidas
            videoEncontrado.setNombre(datos.getNombre());
            videoEncontrado.setRol(datos.getRol());

            //3. Espacio para volver a guardar el video que se acaba de modificar
            this.repositorio.save(videoEncontrado);

        }
    }

}
