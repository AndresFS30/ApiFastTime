/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cliente;
import pojo.Colaborador;
import pojo.Login;

/**
 *
 * @author afs30
 */
public class ImpLogin {
        public static Login validarSesionColaborador(String noPersonal, String password){
        Login respuesta = new Login();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD != null){
        try{
            HashMap<String, String> parametros = new LinkedHashMap<>();
            parametros.put("noPersonal",noPersonal);
            parametros.put("password",password);
            Colaborador colaborador = conexionBD.selectOne("sesion.loginColaborador",parametros);
            if(colaborador != null){
                respuesta.setError(false);
                respuesta.setMensaje("Credenciales correctas del colaborador"+colaborador.getNombre());
                respuesta.setColaborador(colaborador);
                        
            }else{
                respuesta.setError(true);
                respuesta.setMensaje("No. personal y/o password incorrectos");
            }
        }catch(Exception e){
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
        }
     
        }else{
                respuesta.setError(true);
                respuesta.setMensaje("Por el momento no se puede consultar la informacion");
        }
        return respuesta;
    
    }
    
      
}
