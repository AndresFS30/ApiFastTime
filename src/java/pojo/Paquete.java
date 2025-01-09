/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.logging.Logger;

/**
 *
 * @author afs30
 */
public class Paquete {
    private Integer idPaquete;
    private String numeroGuia;
    private String descripcionPaquete;
    private Float peso;
    private String dimensiones;
    private Float alto;
    private Float ancho;
    private Float profundidad;
    private Integer idEnvio;
    private String envio;
    private String origen;
    private String destino;
    private String status;
    private String nombre;

    public Paquete(Integer idPaquete, String numeroGuia, String descripcionPaquete, Float peso, String dimensiones, Float alto, Float ancho, Float profundidad, Integer idEnvio, String envio, String origen, String destino, String status, String nombre) {
        this.idPaquete = idPaquete;
        this.numeroGuia = numeroGuia;
        this.descripcionPaquete = descripcionPaquete;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.idEnvio = idEnvio;
        this.envio = envio;
        this.origen = origen;
        this.destino = destino;
        this.status = status;
        this.nombre = nombre;
    }

    public Paquete() {
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Float getAlto() {
        return alto;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
