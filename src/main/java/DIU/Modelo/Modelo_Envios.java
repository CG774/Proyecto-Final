/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Modelo;

import java.math.BigDecimal;

/**
 *
 * @author carlo
 */
public class Modelo_Envios {
    
    private int id_envio;
    private int id_producto;
    private int id_gaveta;
    private BigDecimal cantidad_kg;
    private int id_envio_general;

    public Modelo_Envios() {
    }

    public Modelo_Envios(int id_envio, int id_producto, int id_gaveta, BigDecimal cantidad_kg, int id_envio_general) {
        this.id_envio = id_envio;
        this.id_producto = id_producto;
        this.id_gaveta = id_gaveta;
        this.cantidad_kg = cantidad_kg;
        this.id_envio_general = id_envio_general;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_gaveta() {
        return id_gaveta;
    }

    public void setId_gaveta(int id_gaveta) {
        this.id_gaveta = id_gaveta;
    }

    public BigDecimal getCantidad_kg() {
        return cantidad_kg;
    }

    public void setCantidad_kg(BigDecimal cantidad_kg) {
        this.cantidad_kg = cantidad_kg;
    }

    public int getId_envio_general() {
        return id_envio_general;
    }

    public void setId_envio_general(int id_envio_general) {
        this.id_envio_general = id_envio_general;
    }

    @Override
    public String toString() {
        return "Modelo_Envios{" + "id_envio=" + id_envio + ", id_producto=" + id_producto + ", id_gaveta=" + id_gaveta + ", cantidad_kg=" + cantidad_kg + ", id_envio_general=" + id_envio_general + '}';
    }

   
    
    
}
