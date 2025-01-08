/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpAsociacionVehicular;
import dominio.ImpCliente;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.AsociacionVehicular;
import pojo.Mensaje;

/**
 *
 * @author Daniel
 */
@Path("asociacionVehicular")
public class WSAsociacionVehicular {

    @Path("registrarAsociacion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarAsociacion(AsociacionVehicular asociacion) {
        if (asociacion != null && asociacion.getIdUnidad() != null && asociacion.getIdConductor() != null) {
            return ImpAsociacionVehicular.registrarAsociacionVehicular(asociacion.getIdUnidad(), asociacion.getIdConductor());
        } else {
            throw new BadRequestException("Los parámetros idUnidad e idConductor son obligatorios.");
        }
    }
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AsociacionVehicular> listarAsociaciones() {
        try {
            return ImpAsociacionVehicular.obtenerAsociaciones();

        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("error");
        }
    }
    @Path("eliminarAsociacion/{idAsociacion}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarAsociacion(@PathParam("idAsociacion") Integer idAsociacion) {
         if((idAsociacion != null) && (idAsociacion > 0)){
            return ImpAsociacionVehicular.eliminarAsociacion(idAsociacion);
        }
        throw new BadRequestException();
    }
    @Path("asociarEnvio")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje asociarEnvio(AsociacionVehicular asociacion) {
        if (asociacion != null && asociacion.getIdEnvio() != null && asociacion.getIdConductor() != null) {
            return ImpAsociacionVehicular.asociarEnvio(asociacion.getIdConductor(),asociacion.getIdEnvio());
        } else {
            throw new BadRequestException("Los parámetros idUnidad e idConductor son obligatorios.");
        }
    }
}
