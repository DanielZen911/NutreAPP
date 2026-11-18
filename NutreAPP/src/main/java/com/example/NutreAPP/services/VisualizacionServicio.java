package com.example.NutreAPP.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service
public class VisualizacionServicio {

    @Autowired
    private IVisualizacionRepositorio repositorio;

    public Visualizacion guardar(Visualizacion datos){
    return this.repositorio.save(datos);
    }

        //Metodo para buscar po Id
    public Visualizacion buscarPorId(UUID id){
        Optional<Visualizacion> visualizacionBusacado = this.repositorio.findById(id);
        if(!visualizacionBuscado.isPresent()){
            throw new ResolutionException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return visualizacionBuscado.get();
        }
    }

    //Metodo para buscar todos
    public List<Visualizacion> buscarTodos(){
        return this.respositorio.findAll();
    }


}
