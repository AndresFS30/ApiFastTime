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
public class Colaborador {
       private Integer IdColaborador;
       private String Nombre;
       private String ApellidoPaterno;
       private String ApellidoMaterno;
       private String CURP;
       private String Correo;
       private String Password;
       private Integer IdRol;
       private String Rol;
       private String fotoBase64;
       private String noLicencia;

    public Colaborador() {
    }

    public Colaborador(Integer IdColaborador, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String CURP, String Correo, String Password, Integer IdRol, String Rol, String fotoBase64, String noLicencia) {
        this.IdColaborador = IdColaborador;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.CURP = CURP;
        this.Correo = Correo;
        this.Password = Password;
        this.IdRol = IdRol;
        this.Rol = Rol;
        this.fotoBase64 = fotoBase64;
        this.noLicencia = noLicencia;
    }

    public Integer getIdColaborador() {
        return IdColaborador;
    }

    public void setIdColaborador(Integer IdColaborador) {
        this.IdColaborador = IdColaborador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public String getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(String noLicencia) {
        this.noLicencia = noLicencia;
    }

    
}
