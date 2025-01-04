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
public class StatusEnvio {
    private Integer idStatus;
    private Integer idEnvio;
    private String status;

    public StatusEnvio() {
    }

    public StatusEnvio(Integer idStatus, Integer idEnvio, String status) {
        this.idStatus = idStatus;
        this.idEnvio = idEnvio;
        this.status = status;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
