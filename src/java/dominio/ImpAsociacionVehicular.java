/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
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
}
