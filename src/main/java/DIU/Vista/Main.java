package DIU.Vista;

import DIU.Inicio_de_sesion;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        Inicio_de_sesion login = new Inicio_de_sesion();
        login.setVisible(true);
    }

}
