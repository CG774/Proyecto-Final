package DIU.Modelo;

public class Modelo_Proveedor {
    private int id;
    private String nombre;
    private String telefono;
    
    public Modelo_Proveedor() {
    }

    public Modelo_Proveedor(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
