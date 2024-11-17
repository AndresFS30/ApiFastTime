/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author afs30
 */
public class Paquete {
    private String descripcion;
    private Integer peso;
    private String dimensiones;
    private Integer alto;
    private Integer ancho;
    private Integer profundidad;
    private Integer idEnvio;

    public Paquete() {
    }

    public Paquete(String descripcion, Integer peso, String dimensiones, Integer alto, Integer ancho, Integer profundidad, Integer idEnvio) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.idEnvio = idEnvio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }
    
    
}
