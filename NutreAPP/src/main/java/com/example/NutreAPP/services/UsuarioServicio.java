package com.example.NutreAPP.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;
import com.example.NutreAPP.repositories.IVideoRepositorio;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 

public class UsuarioServicio {

    //Para cocinar neceito las recetas
    //Para programar los ervicios necesito los repositorios

    //INYECCION DE DEPENDENCIAS
    @Autowired 
    private IUsuarioRepositorio repositorio;

    //Metodo para guardar
    public Usuario guardar(Usuario datos){
        return this.repositorio.save(datos);
    }

    //Metodo para buscar po Id
    public Usuario buscarPorId(UUID id){
        Optional<Usuario> usuarioBusacado = this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResolutionException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return usuarioBuscado.get();
        }
    }

    //Metodo para buscar todos
    public List<Usuario> buscarTodos(){
        return this.respositorio.findAll();
    }

    //Metodo para eliminar

    //Metodo para buscar por departamento y rol

    //Metodo para buscar por correo

    //Metodo para rol

    //Metodo para verificar correo

}
