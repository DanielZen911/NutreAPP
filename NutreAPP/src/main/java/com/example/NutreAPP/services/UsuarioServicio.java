package com.example.NutreAPP.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return usuarioBuscado.get();
        }
    }

    //Metodo para buscar todos
    public List<Usuario> buscarTodos(){
        return this.repositorio.findAll();
    }

    //Metodo para actualizar (modificar)
    public Usuario modificar(UUID id, Usuario datos){
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{

            //1. RECARGAR LA INFO QUE EXISTE ACTUALMENTE EN BD
            Usuario usuarioEncontrado=usuarioBuscado.get();

            //2. Espacio para modificar solo las propiedades permitidas
            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioEncontrado.setRol(datos.getRol());

            //3. Espacio para volver a guardar el usuario que se acaba de modificar
            this.repositorio.save(usuarioEncontrado);

        }
    }

    //Metodo para eliminar

    public boolean eliminar(UUID id){
        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            this.repositorio.deleteById(id);
            return true;
        }


    }

    //Metodo para buscar por departamento y rol

    //Metodo para buscar por correo

    //Metodo para rol

    //Metodo para verificar correo

}
