/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

public class AsociacionVehicular {
    private Integer idUnidad;
    private String unidad;
    private Integer idConductor;
    private String Conductor;
    private Integer idAsociacion;
    private String envioAsociado;

    public AsociacionVehicular() {
    }

    public AsociacionVehicular(Integer idUnidad, String unidad, Integer idConductor, String Conductor, Integer idAsociacion, String envioAsociado) {
        this.idUnidad = idUnidad;
        this.unidad = unidad;
        this.idConductor = idConductor;
        this.Conductor = Conductor;
        this.idAsociacion = idAsociacion;
        this.envioAsociado = envioAsociado;
    }

    public String getEnvioAsociado() {
        return envioAsociado;
    }

    public void setEnvioAsociado(String envioAsociado) {
        this.envioAsociado = envioAsociado;
    }

    

    public Integer getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(Integer idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    
   
    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getConductor() {
        return Conductor;
    }

    public void setConductor(String Conductor) {
        this.Conductor = Conductor;
    }

    
}
