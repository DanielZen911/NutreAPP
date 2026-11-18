package com.example.NutreAPP.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
            throw new ResolutionException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return videoBuscado.get();
        }
    }

    //Metodo para buscar todos
    public List<Video> buscarTodos(){
        return this.respositorio.findAll();
    }


}
