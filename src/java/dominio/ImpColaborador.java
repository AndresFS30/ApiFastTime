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
import java.util.Map;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.Mensaje;

/**
 *
 * @author afs30
 */
public class ImpColaborador {
    
public static List<Colaborador> obtenerColaborador() {
    List<Colaborador> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
          lista = conexionBD.selectList("colaborador.obtenerColaborador", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

public static List<Colaborador> obtenerColaboradorNombre(String Nombre) {
    List<Colaborador> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("Nombre", Nombre);
            lista = conexionBD.selectList("colaborador.obtenerColaboradorNombre", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

public static List<Colaborador> obtenerColaboradorNoPersonal(String NoPersonal) {
    List<Colaborador> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("NoPersonal", NoPersonal);
            lista = conexionBD.selectList("colaborador.obtenerColaboradorNoPersonal", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

public static List<Colaborador> obtenerColaboradorRol(String Rol) {
    List<Colaborador> lista = new ArrayList();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if (conexionBD != null) {
        try {
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("Rol", Rol);
            lista = conexionBD.selectList("colaborador.obtenerColaboradorRol", parametros);
 
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            conexionBD.close();
        }
    }
    return lista;
}

    public static Mensaje registrarColaborador(Colaborador colaborador) {
    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
    Mensaje mensaje = new Mensaje();
    try {
        // Crear un mapa con los parámetros para el procedimiento almacenado
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", colaborador.getNombre());
        parametros.put("apellidoPaterno", colaborador.getApellidoPaterno());
        parametros.put("apellidoMaterno", colaborador.getApellidoMaterno());
        parametros.put("curp", colaborador.getCurp());
        parametros.put("correo", colaborador.getCorreo());
        parametros.put("password", colaborador.getPassword());
        parametros.put("idRol", colaborador.getIdRol());
        parametros.put("noPersonal", colaborador.getNoPersonal());
        parametros.put("numeroLicencia", colaborador.getNumeroLicencia());

        // Llamar al procedimiento almacenado
        session.insert("colaborador.registrarColaborador", parametros);
        session.commit();

        mensaje.setError(false);
        mensaje.setMensaje("Colaborador registrado correctamente.");
    } catch (Exception e) {
        e.printStackTrace();
        session.rollback();
        mensaje.setError(true);
        mensaje.setMensaje("Error al registrar el colaborador: " + e.getMessage());
    } finally {
        session.close();
    }
    return mensaje;
}

    
    public static Mensaje editarColaborador( Colaborador colaborador){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD!= null){
    try{
         int resultado =conexionBD.update("colaborador.editarColaborador", colaborador);
         conexionBD.commit();
         if(resultado > 0){
             respuesta.setError(false);
             respuesta.setMensaje("Colaborador editado con exito");
         }else{
             respuesta.setError(true);
             respuesta.setMensaje("no se pudo editar al colaborador, intentarlo mas tarde.");
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
    
    public static Mensaje eliminarColaborador(Integer IdColaborador){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD != null){
        try{
        HashMap<String, Integer> parametros = new LinkedHashMap<>();
        parametros.put("IdColaborador", IdColaborador);
        int filasAfectadas = conexionBD.delete("colaborador.eliminarColaboradorId" ,parametros);
         if(filasAfectadas > 0){
                respuesta.setError(false);
                respuesta.setMensaje("Colaborador eliminado");
                
            }else{
                respuesta.setError(true);
                respuesta.setMensaje("No se pudo eliminar el colaborador");
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
    
    
    public static Mensaje actualizarConductor(Colaborador colaborador){
     Mensaje msj = new Mensaje();
     SqlSession conexionBD = MyBatisUtil.obtenerConexion();
     if(conexionBD!= null){
         try{
         int resultado =conexionBD.insert("colaborador.actualizarConductor", colaborador);
         conexionBD.commit();
         if(resultado > 0){
             msj.setError(false);
             msj.setMensaje("Licencia actualizada con exito");
         }else{
             msj.setError(true);
             msj.setMensaje("no se pudo actualizar Licencia, intentarlo mas tarde.");
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
    
    public static  Mensaje registrarFoto(Integer IdColaborador, byte[] Foto){
    Mensaje msj = new Mensaje();
     LinkedHashMap<String, Object> parametros = new LinkedHashMap<>();
        parametros.put("IdColaborador", IdColaborador);
        parametros.put("Foto", Foto);
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
        try{
         int filasAfectadas = conexionBD.update("colaborador.guardarFoto",parametros);
         conexionBD.commit();
          if(filasAfectadas >0){
           msj.setError(false);
           msj.setMensaje("foto guardada correctamente en la base ");
          }else{
           msj.setError(true);
           msj.setMensaje("No se pudo realizar el guardado de la foto");
          }
            
        }catch(Exception e){
        
         msj.setError(true);
         msj.setMensaje(e.getMessage());
        }
            
        }else{
        
         msj.setError(true);
           msj.setMensaje("No se pudo establecer conexión a la base de datos");
        
        }
        return msj;   
    }
    
    public static Colaborador obtenerFoto(Integer IdColaborador){
     Colaborador colaborador = null;
     SqlSession conexionBD = MyBatisUtil.obtenerConexion();
     if(conexionBD != null){
         try{
           colaborador = conexionBD.selectOne("colaborador.obtenerFoto",IdColaborador);
         }catch(Exception e){
             e.printStackTrace();
         }
     }
     return colaborador;
    }
    
     

}
