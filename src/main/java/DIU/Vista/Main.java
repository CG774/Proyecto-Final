/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DIU.Vista;

import DIU.Inicio_de_sesion;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author carlo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        Inicio_de_sesion login = new Inicio_de_sesion();
        login.setVisible(true);
    }
    
}
