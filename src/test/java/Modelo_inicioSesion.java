/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DIU.Modelo.*;

public class Modelo_inicioSesion {
    private String ususario;
    private String contraseña;
    
    public Modelo_inicioSesion() {
    }

    public Modelo_inicioSesion(String ususario, String contraseña) {
        this.ususario = ususario;
        this.contraseña = contraseña;
    }

    public String getUsusario() {
        return ususario;
    }

    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
