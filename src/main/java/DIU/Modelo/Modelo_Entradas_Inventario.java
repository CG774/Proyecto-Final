/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Modelo;

/**
 *
 * @author carlo
 */
public class Modelo_Entradas_Inventario {
    
    private int id_entrada;
    private int id_producto;
    private int id_proveedor;
    private int fecha_entrada;
    private String cantidad;
    private String id_gaveta;

    public Modelo_Entradas_Inventario() {
    }

    public Modelo_Entradas_Inventario(int id_entrada, int id_producto, int id_proveedor, int fecha_entrada, String cantidad, String id_gaveta) {
        this.id_entrada = id_entrada;
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.fecha_entrada = fecha_entrada;
        this.cantidad = cantidad;
        this.id_gaveta = id_gaveta;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(int fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_gaveta() {
        return id_gaveta;
    }

    public void setId_gaveta(String id_gaveta) {
        this.id_gaveta = id_gaveta;
    }
    
    
}
