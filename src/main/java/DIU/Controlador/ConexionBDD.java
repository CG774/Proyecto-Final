package DIU.Controlador;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBDD {
    java.sql.Connection conexion;
     public java.sql.Connection conectar(){
        //LANZAR CÓDIGO DE PRUEBA 
        try {
            //Manera de Conexión a la Base de Datos
            Class.forName("com.mysql.jdbc.Driver");
            //Parámetros de conexión url/usuario/clave en mysql
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/bddproyectofinal?autoReconnect=true&useSSL=false","CarlosGordillo","Carlosd14");

            //conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyecto1?autoReconnect=true&useSSL=false","root","1005023849oe");

        } catch (ClassNotFoundException | SQLException e)//CAPTURAR ERRORES 
        {
             System.out.println("ERROR DE CONEXION A LA BASE DE DATOS");
        }
        return conexion;
    }
    
}
