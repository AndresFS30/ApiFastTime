/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpCliente;
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
import pojo.Mensaje;

/**
 *
 * @author afs30
 */
@Path("cliente")
public class WSCliente {
     @Context
    private UriInfo context;
    
    public WSCliente() {
    }
    
    @Path("obtenerCliente")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> obtenerCliente(){
    
        return ImpCliente.obtenerCliente();
        
    }
    
    @GET
    @Path("obtenerClienteNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteNombre(@PathParam("nombre")String nombre){
         if( (nombre != null) && !(nombre.isEmpty())){
            return ImpCliente.obtenerClienteNombre(nombre);
        }
        throw new BadRequestException();
    }
    
    
    @GET
    @Path("obtenerClienteTelefono/{telefono}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteTelefono(@PathParam("telefono")String telefono){
        if( (telefono != null) && !(telefono.isEmpty())){
            return ImpCliente.obtenerClienteTelefono(telefono);
        }
        throw new BadRequestException();
    }
    
    
    @GET
    @Path("obtenerClienteCorreo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteCorreo(@PathParam("correo")String correo){
      if( (correo != null) && !(correo.isEmpty())){
            return ImpCliente.obtenerClienteCorreo(correo);
        }
        throw new BadRequestException();
    }
    
    
    @Path("registrarCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarCliente(String jsonCliente){
        
       try{
       Gson gson = new Gson();
        Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
        return ImpCliente.registrarCliente(cliente);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
    
    @Path("editarCliente")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarCliente(String jsonCliente){
        try{
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
        return ImpCliente.editarCliente(cliente);
        }catch( Exception e){
            e.printStackTrace();
            throw new BadRequestException();
        }
    }
    
    @Path("eliminarCliente/{idCliente}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCliente(@PathParam("idCliente") Integer idCliente) {
         if((idCliente != null) && (idCliente > 0)){
            return ImpCliente.eliminarCliente(idCliente);
        }
        throw new BadRequestException();
    }
    
    @Path("registrarDireccion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarDireccion(String jsonCliente){
        
       try{
       Gson gson = new Gson();
        Cliente cliente = gson.fromJson(jsonCliente, Cliente.class);
        return ImpCliente.registrarDireccion(cliente);
       
       }catch(Exception e){
        e.printStackTrace();
        throw new BadRequestException();
       }
        
    }
}
