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
    private String Año;
    private String VIN;
    private Integer IdTipo;
    private String IdInterno;

    public Unidad() {
    }

    public Unidad(Integer IdUnidad, String Marca, String Modelo, String Año, String VIN, Integer IdTipo, String IdInterno) {
        this.IdUnidad = IdUnidad;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Año = Año;
        this.VIN = VIN;
        this.IdTipo = IdTipo;
        this.IdInterno = IdInterno;
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

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
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
