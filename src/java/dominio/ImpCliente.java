/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cliente;
import pojo.Mensaje;

/**
 *
 * @author afs30
 */
public class ImpCliente {
    
    
    public static List <Cliente> obtenerCliente() {
    List<Cliente> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
          lista = conexionBD.selectList("cliente.obtenerCliente", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}
    
public static List<Cliente> obtenerClienteNombre(String nombre) {
    List<Cliente> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("nombre", nombre);
            lista = conexionBD.selectList("cliente.obtenerClienteNombre", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}
  
public static List<Cliente> obtenerClienteTelefono(String telefono) {
    List<Cliente> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("telefono", telefono);
            lista = conexionBD.selectList("cliente.obtenerClienteTelefono", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

public static List<Cliente> obtenerClienteCorreo(String correo) {
    List<Cliente> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("correo", correo);
            lista = conexionBD.selectList("cliente.obtenerClienteCorreo", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

    public static Mensaje registrarCliente(Cliente cliente){
     Mensaje msj = new Mensaje();
     SqlSession conexionBD = MyBatisUtil.obtenerConexion();
     if(conexionBD!= null){
         try{
         int resultado =conexionBD.insert("cliente.registrarCliente", cliente);
         conexionBD.commit();
         if(resultado > 0){
             msj.setError(false);
             msj.setMensaje("Cliente registrado con exito");
         }else{
             msj.setError(true);
             msj.setMensaje("no se pudo registrar al cliente, intentarlo mas tarde.");
         }
         }catch(Exception e){
         msj.setError(true);
         msj.setMensaje(e.getMessage());
         }finally{
        conexionBD.close();
        }
     }else{
         msj.setError(true);
         msj.setMensaje("No se pudo establecer conexión a la base de datos");
     }
    return msj;
    }
    
    public static Mensaje editarCliente( Cliente cliente){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD!= null){
    try{
         int resultado =conexionBD.update("cliente.editarCliente", cliente);
         conexionBD.commit();
         if(resultado > 0){
             respuesta.setError(false);
             respuesta.setMensaje("Cliente editado con exito");
         }else{
             respuesta.setError(true);
             respuesta.setMensaje("no se pudo editar al cliente, intentarlo mas tarde.");
         }
         }catch(Exception e){
         respuesta.setError(true);
         respuesta.setMensaje(e.getMessage());
         }finally{
        conexionBD.close();
        }
    } else{
        respuesta.setError(true);
         respuesta.setMensaje("No se pudo establecer conexión a la base de datos");
     }
    return respuesta;
    }
    
    
    public static Mensaje eliminarCliente(Integer idCliente){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD != null){
        try{
        HashMap<String, Integer> parametros = new LinkedHashMap<>();
        parametros.put("idCliente", idCliente);
        int filasAfectadas = conexionBD.delete("cliente.eliminarClienteId" ,parametros);
         if(filasAfectadas > 0){
                respuesta.setError(false);
                respuesta.setMensaje("Cliente eliminado");

            }else{
                respuesta.setError(true);
                respuesta.setMensaje("No se pudo eliminar el cliente");
            }
            conexionBD.commit();
          }catch(Exception e){
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());

        }finally{
        conexionBD.close();
        }

    }else {
         respuesta.setError(true);
         respuesta.setMensaje("Por el momento no se puede consultar la informacion");
    }
    return respuesta ;
    }
    
    
    
    public static Mensaje registrarDireccion(Cliente cliente){
     Mensaje msj = new Mensaje();
     SqlSession conexionBD = MyBatisUtil.obtenerConexion();
     if(conexionBD!= null){
         try{
         int resultado =conexionBD.insert("cliente.registrarDireccion", cliente);
         conexionBD.commit();
         if(resultado > 0){
             msj.setError(false);
             msj.setMensaje("Direccion registrada con exito");
         }else{
             msj.setError(true);
             msj.setMensaje("no se pudo registrar direcciom, intentarlo mas tarde.");
         }
         }catch(Exception e){
         msj.setError(true);
         msj.setMensaje(e.getMessage());
         }finally{
        conexionBD.close();
        }
     }else{
         msj.setError(true);
         msj.setMensaje("No se pudo establecer conexión a la base de datos");
     }
    return msj;
    }
}
