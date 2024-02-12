package DIU.Controlador;

import DIU.Modelo.Modelo_inicioSesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inicioSesion {

    private Modelo_inicioSesion login;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;

    public boolean iniciarSesion(Modelo_inicioSesion log) {
        boolean estado = false;
        try {
            String SQL = "CALL ValidarLogin('" + log.getUsusario() + "','" + log.getContraseña() + "')";
            ejecutar = conectado.prepareStatement(SQL);
            ResultSet res = ejecutar.executeQuery();

            if (res.next()) {
                String resultado = res.getString(1);

                if ("Correcto".equals(resultado)) {
                    System.out.println("Inicio de sesión exitoso");
                    estado = true;
                } else {
                    System.out.println("Inicio de sesión incorrecto");
                    estado = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un fallo. Compruebe los datos de conexión a la base de datos.");
        }
        return estado;
    }
}
