/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Modelo;

/**
 *
 * @author carlo
 */
public class Modelo_Productos {
    private int idProducto;
    private String nombreProducto;

    public Modelo_Productos() {
    }

    public Modelo_Productos(int idProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }
    
    

    public Modelo_Productos(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                '}';
    }
}

