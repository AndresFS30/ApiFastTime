
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpCliente;
import dominio.ImpColaborador;
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
import pojo.Cliente;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.Respuesta;

/**
 *
 * @author afs30
 */
@Path("colaborador")
public class WSColaborador {
       @Context
    private UriInfo context;
   
   public WSColaborador() {
    }
   
    @Path("obtenerColaborador")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerColaborador(){
    
        return ImpColaborador.obtenerColaborador();
        
    }
    
    
    @GET
    @Path("obtenerColaboradorNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorNombre(@PathParam("nombre")String nombre){
        if( (nombre != null) && !(nombre.isEmpty())){
            return ImpColaborador.obtenerColaboradorNombre(nombre);
        }
        throw new BadRequestException();
        
    }
    
    @GET
    @Path("obtenerColaboradorNoPersonal/{noPersonal}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorNoPersonal(@PathParam("noPersonal")String noPersonal){
       
        if( (noPersonal != null) && !(noPersonal.isEmpty())){
            return ImpColaborador.obtenerColaboradorNoPersonal(noPersonal);
        }
        throw new BadRequestException();
    }
    
    @GET
    @Path("obtenerColaboradorRol/{rol}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorRol(@PathParam("rol")String rol){
       
        if((rol != null) && !(rol.isEmpty())){
            return ImpColaborador.obtenerColaboradorRol(rol);
        }
        throw new BadRequestException();
        
    }
    
    @Path("registrarColaborador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarColaborador(String jsonColaborador){
        
       try{
       Gson gson = new Gson();
        Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
        return ImpColaborador.registrarColaborador(colaborador);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
    @Path("editarColaborador")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarColaborador(String jsonColaborador){
        try{
        Gson gson = new Gson();
        Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
        return ImpColaborador.editarColaborador(colaborador);
        }catch( Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarColaborador")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarColaborador(@QueryParam("idColaborador") Integer idColaborador) {
        if((idColaborador != null) && (idColaborador > 0)){
            return ImpColaborador.eliminarColaborador(idColaborador);
        }
        throw new BadRequestException();
    }
    
    @Path("actualizarConductor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje actualizarConductor(String jsonColaborador){
        
       try{
       Gson gson = new Gson();
        Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
        return ImpColaborador.actualizarConductor(colaborador);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
}
