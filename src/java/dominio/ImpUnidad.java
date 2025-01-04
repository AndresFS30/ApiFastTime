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
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.Unidad;

/**
 *
 * @author afs30
 */
public class ImpUnidad {

    
    public static List<Unidad> obtenerUnidad() {
    List<Unidad> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
          lista = conexionBD.selectList("unidad.obtenerUnidad", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}
    
public static List<Unidad> obtenerUnidadVIN(String vin) {
    List<Unidad> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("vin", vin);
            lista = conexionBD.selectList("unidad.obtenerUnidadVIN", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

public static List<Unidad> obtenerUnidadMarca(String marca) {
    List<Unidad> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("marca", marca);
            lista = conexionBD.selectList("unidad.obtenerUnidadMarca", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}


public static List<Unidad> obtenerUnidadIdInterno(String idInterno) {
    List<Unidad> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("idInterno", idInterno);
            lista = conexionBD.selectList("unidad.obtenerUnidadIdInterno", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}




 public static Mensaje registrarUnidad(Unidad unidad){
     Mensaje msj = new Mensaje();
     SqlSession conexionBD = MyBatisUtil.obtenerConexion();
     if(conexionBD!= null){
         try{
         int resultado =conexionBD.insert("unidad.registrarUnidad", unidad);
         conexionBD.commit();
         if(resultado > 0){
             msj.setError(false);
             msj.setMensaje("Unidad registrada con exito");
         }else{
             msj.setError(true);
             msj.setMensaje("no se pudo registrar la Unidad, intentarlo mas tarde.");
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
    
    public static Mensaje editarUnidad( Unidad unidad){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD!= null){
    try{
         int resultado =conexionBD.update("unidad.editarUnidad", unidad);
         conexionBD.commit();
         if(resultado > 0){
             respuesta.setError(false);
             respuesta.setMensaje("Unidad editada con exito");
         }else{
             respuesta.setError(true);
             respuesta.setMensaje("no se pudo editar la Unidad, intentarlo mas tarde.");
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
    
    public static Mensaje eliminarUnidad(Integer idUnidad){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD != null){
        try{
        HashMap<String, Integer> parametros = new LinkedHashMap<>();
        parametros.put("idUnidad", idUnidad);
        int filasAfectadas = conexionBD.delete("unidad.eliminarUnidadId" ,parametros);
         if(filasAfectadas > 0){
                respuesta.setError(false);
                respuesta.setMensaje("Unidad eliminada");
                
            }else{
                respuesta.setError(true);
                respuesta.setMensaje("No se pudo eliminar la Unidad");
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
}
