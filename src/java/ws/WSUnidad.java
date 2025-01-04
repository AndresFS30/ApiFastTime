/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpColaborador;
import dominio.ImpUnidad;
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
import pojo.Unidad;

/**
 *
 * @author afs30
 */

@Path("unidad")
public class WSUnidad {
        @Context
    private UriInfo context;
        
    public WSUnidad(){
    }

    @Path("obtenerUnidad")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad> obtenerUnidad(){
    
        return ImpUnidad.obtenerUnidad();
        
    }
    
    @GET
    @Path("obtenerUnidadVIN/{vin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad>obtenerUnidadVIN(@PathParam("vin")String vin){
       
        if((vin != null) && !(vin.isEmpty())){
           return ImpUnidad.obtenerUnidadVIN(vin);
       } 
        throw new BadRequestException();
    
 
    }
    
    @GET
    @Path("obtenerUnidadMarca/{marca}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad>obtenerUnidadMarca(@PathParam("marca")String marca){
       
        if((marca != null) && !(marca.isEmpty())){
           return ImpUnidad.obtenerUnidadMarca(marca);
       } 
        throw new BadRequestException();
    
 
    }
    
    @GET
    @Path("obtenerUnidadIdInterno/{idInterno}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Unidad>obtenerUnidadIdInterno(@PathParam("idInterno")String idInterno){
       
        if((idInterno != null) && !(idInterno.isEmpty())){
            
        return ImpUnidad.obtenerUnidadIdInterno(idInterno);
       } 
        throw new BadRequestException();
    
 
    }
    
    
    @Path("registrarUnidad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarUnidad(String jsonUnidad){
        
       try{
       Gson gson = new Gson();
        Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
        return ImpUnidad.registrarUnidad(unidad);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
    @Path("editarUnidad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUnidad(String jsonUnidad){
        try{
        Gson gson = new Gson();
        Unidad unidad = gson.fromJson(jsonUnidad, Unidad.class);
        return ImpUnidad.editarUnidad(unidad);
        }catch( Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarUnidad")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUnidad(@QueryParam("idUnidad") Integer idUnidad) {
               if((idUnidad != null) && (idUnidad > 0)){
            return ImpUnidad.eliminarUnidad(idUnidad);
        }
        throw new BadRequestException();
    }
}
