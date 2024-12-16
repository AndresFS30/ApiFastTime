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
    private Integer IdEnvio;
    private String Status;

    public StatusEnvio() {
    }

    public StatusEnvio(Integer idStatus, Integer IdEnvio, String Status) {
        this.idStatus = idStatus;
        this.IdEnvio = IdEnvio;
        this.Status = Status;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdEnvio() {
        return IdEnvio;
    }

    public void setIdEnvio(Integer IdEnvio) {
        this.IdEnvio = IdEnvio;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
