package com.example.NutreAPP.models;

import java.util.UUID;

import com.example.NutreAPP.models.helpers.Departamento;
import com.example.NutreAPP.models.helpers.Rol;

public class Usuario {

    private UUID id;
    private String nombre;
    private String correo;
    private Rol rol;
    private String contrasenia_hash;
    private Departamento departamento;

    public Usuario() {
    }
  

    public Usuario(UUID id, String nombre, String correo, Rol rol, String contrasenia_hash, Departamento departamento) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.rol = rol;
    this.contrasenia_hash = contrasenia_hash;
    this.departamento = departamento;
}


    public UUID getId() {
    return id;
}


    public void setId(UUID id) {
    this.id = id;
}


    public String getNombre() {
    return nombre;
}


    public void setNombre(String nombre) {
    this.nombre = nombre;
}


    public String getCorreo() {
    return correo;
}


    public void setCorreo(String correo) {
    this.correo = correo;
}


    public Rol getRol() {
    return rol;
}


    public void setRol(Rol rol) {
    this.rol = rol;
}


    public String getContrasenia_hash() {
    return contrasenia_hash;
}


    public void setContrasenia_hash(String contrasenia_hash) {
    this.contrasenia_hash = contrasenia_hash;
}


    public Departamento getDepartamento() {
    return departamento;
}


    public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
}  



    


}
