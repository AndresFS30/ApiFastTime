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
    private String conductor;
    private Integer idAsociacion;
    private Integer idEnvio;
    private String envioAsociado;

    public AsociacionVehicular(Integer idUnidad, String unidad, Integer idConductor, String conductor, Integer idAsociacion, Integer idEnvio, String envioAsociado) {
        this.idUnidad = idUnidad;
        this.unidad = unidad;
        this.idConductor = idConductor;
        this.conductor = conductor;
        this.idAsociacion = idAsociacion;
        this.idEnvio = idEnvio;
        this.envioAsociado = envioAsociado;
    }

    public AsociacionVehicular() {
    }
    
    
    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
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
        return conductor;
    }

    public void setConductor(String Conductor) {
        this.conductor = Conductor;
    }

    
}
