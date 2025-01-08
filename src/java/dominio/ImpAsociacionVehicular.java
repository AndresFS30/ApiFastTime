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
import pojo.AsociacionVehicular;
import pojo.Cliente;
import pojo.Mensaje;

/**
 *
 * @author Daniel
 */
public class ImpAsociacionVehicular {

    public static Mensaje registrarAsociacionVehicular(Integer idUnidad, Integer idConductor) {
        Mensaje mensaje = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                // Crear un objeto para insertar
                HashMap<String, Integer> parametros = new HashMap<>();
                parametros.put("idUnidad", idUnidad);
                parametros.put("idConductor", idConductor);

                // Ejecutar la consulta de inserción
                int resultado = conexionBD.insert("asociacionVehicular.registrarAsociacion", parametros);
                conexionBD.commit();

                if (resultado > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Asociación vehicular registrada con éxito.");
                } else {
                    mensaje.setError(true);
                    mensaje.setMensaje("No se pudo registrar la asociación vehicular. Inténtalo más tarde.");
                }
            } catch (Exception e) {
                mensaje.setError(true);
                mensaje.setMensaje(e.getMessage());
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setError(true);
            mensaje.setMensaje("No se pudo establecer conexión con la base de datos.");
        }
        return mensaje;
    }
    
    public static List<AsociacionVehicular> obtenerAsociaciones() {
    List<AsociacionVehicular> lista = new ArrayList();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
              lista = conexionBD.selectList("asociacionVehicular.obtenerAsociaciones", parametros);

            } catch (Exception e) {
            e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return lista;
    }
    public static Mensaje eliminarAsociacion(Integer idAsociacion){
    Mensaje respuesta = new Mensaje();
    SqlSession conexionBD = MyBatisUtil.obtenerConexion();
    if(conexionBD != null){
        try{
        HashMap<String, Integer> parametros = new LinkedHashMap<>();
        parametros.put("idAsociacion", idAsociacion);
        int filasAfectadas = conexionBD.delete("asociacionVehicular.eliminarAsociacion" ,parametros);
         if(filasAfectadas > 0){
                respuesta.setError(false);
                respuesta.setMensaje("Asociacion eliminada");

            }else{
                respuesta.setError(true);
                respuesta.setMensaje("No se pudo eliminar la asociacion");
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
    
    public static Mensaje asociarEnvio(Integer idConductor, Integer idEnvio) {
        Mensaje mensaje = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();

        if (conexionBD != null) {
            try {
                // Crear un objeto para insertar
                HashMap<String, Integer> parametros = new HashMap<>();
                parametros.put("idConductor", idConductor);
                parametros.put("idEnvio", idEnvio);

                // Ejecutar la consulta de inserción
                int resultado = conexionBD.insert("asociacionVehicular.asociarEnvio", parametros);
                conexionBD.commit();

                if (resultado > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Asociación Envio registrada con éxito.");
                } else {
                    mensaje.setError(true);
                    mensaje.setMensaje("No se pudo registrar la asociación vehicular. Inténtalo más tarde.");
                }
            } catch (Exception e) {
                mensaje.setError(true);
                mensaje.setMensaje(e.getMessage());
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        } else {
            mensaje.setError(true);
            mensaje.setMensaje("No se pudo establecer conexión con la base de datos.");
        }
        return mensaje;
    }
}
