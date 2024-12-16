
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
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
    @Path("obtenerColaboradorNombre/{Nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorNombre(@PathParam("Nombre")String Nombre){
                if( (Nombre != null) && !(Nombre.isEmpty())){
            return ImpColaborador.obtenerColaboradorNombre(Nombre);
        }
        throw new BadRequestException();
    }
    
    @GET
    @Path("obtenerColaboradorNoPersonal/{NoPersonal}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorNoPersonal(@PathParam("NoPersonal")String NoPersonal){
       
        
        if( (NoPersonal != null) && !(NoPersonal.isEmpty())){
            return ImpColaborador.obtenerColaboradorNoPersonal(NoPersonal);
        }
        throw new BadRequestException();
    
 
    }
    
    @GET
    @Path("obtenerColaboradorRol/{Rol}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador>obtenerColaboradorRol(@PathParam("Rol")String Rol){
       
        if((Rol != null) && !(Rol.isEmpty())){
            return ImpColaborador.obtenerColaboradorRol(Rol);
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
    public Mensaje eliminarColaborador(@QueryParam("IdColaborador") Integer IdColaborador) {
        if((IdColaborador != null) && (IdColaborador > 0)){
            return ImpColaborador.eliminarColaborador(IdColaborador);
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
    
    @Path("subirFoto/{IdColaborador}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje subirFoto(@PathParam("IdColaborador")Integer IdColaborador,
                                        byte[] Foto){
        if(IdColaborador != null && IdColaborador>0 && Foto != null){
         return ImpColaborador.registrarFoto(IdColaborador,Foto);
        }
       throw new BadRequestException();
   }
    
  @Path("obtenerFoto/{IdColaborador}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
   public Colaborador obtenerFoto(@PathParam("IdColaborador")Integer IdColaborador){
       if(IdColaborador != null && IdColaborador > 0){
           
           return ImpColaborador.obtenerFoto(IdColaborador);
       }
   
       throw new BadRequestException();
   }
    
}
