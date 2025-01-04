/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpColaborador;
import dominio.ImpPaquete;
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
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.Paquete;

/**
 *
 * @author afs30
 */
@Path("paquete")
public class WSPaquete {
        @Context
    private UriInfo context;
   
    public WSPaquete(){
    }
    
    @Path("obtenerPaquete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paquete> obtenerPaquete(){
      return ImpPaquete.obtenerPaquete();
    }
    
    @GET
    @Path("obtenerPaqueteNoGuia/{numeroGuia}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paquete>obtenerPaqueteNoGuia(@PathParam("numeroGuia")String numeroGuia){
        if(numeroGuia != null){
            return ImpPaquete.obtenerPaqueteNoGuia(numeroGuia);
        }
        throw new BadRequestException();
    }
    
    @Path("registrarPaquete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarPaquete(String jsonPaquete){
        
       try{
       Gson gson = new Gson();
        Paquete paquete = gson.fromJson(jsonPaquete, Paquete.class);
        return ImpPaquete.registrarPaquete(paquete);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
    @Path("editarPaquete")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarPaquete(String jsonPaquete){
        try{
        Gson gson = new Gson();
        Paquete paquete = gson.fromJson(jsonPaquete, Paquete.class);
        return ImpPaquete.editarPaquete(paquete);
        }catch( Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarPaquete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarPaquete(@QueryParam("idPaquete") Integer idPaquete) {
      if((idPaquete != null) && (idPaquete > 0)){
            return ImpPaquete.eliminarPaquete(idPaquete);
        }
        throw new BadRequestException();
    }
    
}
