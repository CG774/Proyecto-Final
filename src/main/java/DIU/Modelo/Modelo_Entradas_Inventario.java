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
public class Modelo_Entradas_Inventario {
    
    private int id_entrada;
    private int id_proveedor;
    private int id_producto;
    private BigDecimal cantidadKg;
    

    public Modelo_Entradas_Inventario() {
    }

    public Modelo_Entradas_Inventario(int id_entrada, int id_proveedor, int id_producto, BigDecimal cantidadKg) {
        this.id_entrada = id_entrada;
        this.id_proveedor = id_proveedor;
        this.id_producto = id_producto;
        this.cantidadKg = cantidadKg;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public BigDecimal getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(BigDecimal cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    @Override
    public String toString() {
        return "Modelo_Entradas_Inventario{" + "id_entrada=" + id_entrada + ", id_proveedor=" + id_proveedor + ", id_producto=" + id_producto + ", cantidadKg=" + cantidadKg + '}';
    }
    
    
}
