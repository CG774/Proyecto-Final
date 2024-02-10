/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIU.Modelo;

/**
 *
 * @author carlo
 */
public class Modelo_Gavetas {
    
    private String id_gaveta;
    private String peso_maximo;
    private String tamanio;
    private String es_generica;
    private int id_producto;

    public Modelo_Gavetas() {
    }

    public String getId_gaveta() {
        return id_gaveta;
    }

    public void setId_gaveta(String id_gaveta) {
        this.id_gaveta = id_gaveta;
    }

    public String getPeso_maximo() {
        return peso_maximo;
    }

    public void setPeso_maximo(String peso_maximo) {
        this.peso_maximo = peso_maximo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getEs_generica() {
        return es_generica;
    }

    public void setEs_generica(String es_generica) {
        this.es_generica = es_generica;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
}
