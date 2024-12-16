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
    @Path("obtenerClienteNombre/{Nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteNombre(@PathParam("Nombre")String Nombre){
         if( (Nombre != null) && !(Nombre.isEmpty())){
            return ImpCliente.obtenerClienteNombre(Nombre);
        }
        throw new BadRequestException();
    }
    
    
    @GET
    @Path("obtenerClienteTelefono/{Telefono}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteTelefono(@PathParam("Telefono")String Telefono){
        if( (Telefono != null) && !(Telefono.isEmpty())){
            return ImpCliente.obtenerClienteTelefono(Telefono);
        }
        throw new BadRequestException();
    }
    
    
    @GET
    @Path("obtenerClienteCorreo/{Correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente>obtenerClienteCorreo(@PathParam("Correo")String Correo){
      if( (Correo != null) && !(Correo.isEmpty())){
            return ImpCliente.obtenerClienteCorreo(Correo);
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
    
    @Path("eliminarCliente")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCliente(@QueryParam("IdCliente") Integer IdCliente) {
         if((IdCliente != null) && (IdCliente > 0)){
            return ImpCliente.eliminarCliente(IdCliente);
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
