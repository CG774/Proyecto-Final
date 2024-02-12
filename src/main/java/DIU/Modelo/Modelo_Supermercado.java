package DIU.Modelo;

public class Modelo_Supermercado {
    private int id_supermercado;
    private String nombre;
    private String telefono;

    public Modelo_Supermercado() {
    }

    public Modelo_Supermercado(int id_supermercado, String nombre, String telefono) {
        this.id_supermercado = id_supermercado;
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public int getId_supermercado() {
        return id_supermercado;
    }

    public void setId_supermercado(int id_supermercado) {
        this.id_supermercado = id_supermercado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
