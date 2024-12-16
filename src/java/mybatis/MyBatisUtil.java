/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author afs30
 */
public class MyBatisUtil {
        private static final String RESOURCE = "mybatis/mybatis-config.xml";
    private static final String ENVIROMENT = "development";
    
    public static SqlSession obtenerConexion(){
    SqlSession conexionBD = null;
        try{
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactory abrirSesion = new SqlSessionFactoryBuilder().build(reader,ENVIROMENT); 
            conexionBD = abrirSesion.openSession();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return conexionBD;
    }
    
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis/mybatis-config.xml"; // Archivo de configuración de MyBatis
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar MyBatisUtils: " + e.getMessage());
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}

    

