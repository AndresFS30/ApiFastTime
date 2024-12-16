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
public class Unidad {

    
    private Integer IdUnidad;
    private String Marca;
    private String Modelo;
    private String anio;
    private String vin;
    private Integer IdTipo;
    private String IdInterno;

   

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }
    private String tipoUnidad;

    public Unidad() {
    }

    public Unidad(Integer IdUnidad, String Marca, String Modelo, String anio, String vin, Integer IdTipo, String IdInterno, String tipoUnidad) {
        this.IdUnidad = IdUnidad;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.anio = anio;
        this.vin = vin;
        this.IdTipo = IdTipo;
        this.IdInterno = IdInterno;
        this.tipoUnidad = tipoUnidad;
    }

    public Integer getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(Integer IdUnidad) {
        this.IdUnidad = IdUnidad;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getanio() {
        return anio;
    }

    public void setanio(String anio) {
        this.anio = anio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(Integer IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getIdInterno() {
        return IdInterno;
    }

    public void setIdInterno(String IdInterno) {
        this.IdInterno = IdInterno;
    }

    

   
   
}
