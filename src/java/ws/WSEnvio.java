/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpEnvio;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Envio;
import pojo.Mensaje;
import pojo.StatusEnvio;

/**
 *
 * @author afs30
 */
@Path("envio")
public class WSEnvio {
           @Context
    private UriInfo context;
           
    public WSEnvio(){
    
    }
    
    @Path("obtenerEnvio")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio>obtenerEnvio(){
        return ImpEnvio.obtenerEnvio();
    }
    
    @Path("obtenerNumerosGuias")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio>obtenerNumerosGuias(){
        return ImpEnvio.obtenerNumerosGuias();
    }
    
    
    @Path("obtenerEnvioNoGuia/{NumeroGuia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio>obtenerEnvioNoGuia(@PathParam("NumeroGuia")String NumeroGuia){
        return ImpEnvio.obtenerEnvioNoGuia(NumeroGuia);
    }
    @Path("obtenerEstatus/{idEnvio}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio>obtenerEstatus(@PathParam("idEnvio")Integer idEnvio){
        return ImpEnvio.obtenerEstatus(idEnvio);
    }


    @Path("obtenerEnvioNoLicencia/{numeroLicencia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Envio> obtenerEnvioNoLicencia(@PathParam("numeroLicencia") String numeroLicencia) {
    return ImpEnvio.obtenerEnvioNoLicencia(numeroLicencia);
    }

    
    @Path("registrarEnvio")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarEnvio(String jsonEnvio){
        
       try{
       Gson gson = new Gson();
        Envio envio = gson.fromJson(jsonEnvio, Envio.class);
        return ImpEnvio.registrarEnvio(envio);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
    @Path("editarEnvio")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarEnvio(String jsonEnvio){
        try{
        Gson gson = new Gson();
        Envio envio = gson.fromJson(jsonEnvio, Envio.class);
        return ImpEnvio.editarEnvio(envio);
        }catch( Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarEnvio/{idEnvio}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEnvio(@PathParam("idEnvio") Integer idEnvio) {
        return ImpEnvio.eliminarEnvio(idEnvio);
    }
    
    
    @Path("cambiarEstatus")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje cambiarEstatus(String jsonEstatus){
        
       try{
       Gson gson = new Gson();
        StatusEnvio estatus = gson.fromJson(jsonEstatus, StatusEnvio.class);
        return ImpEnvio.cambiarEstatus(estatus);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
}
