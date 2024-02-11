package DIU.Modelo;

public class Modelo_Proveedor {
    private int id;
    private String nombre;
    private Modelo_Productos producto;

    public Modelo_Proveedor() {
    }

    public Modelo_Proveedor(int id, String nombre, Modelo_Productos producto) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
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

    public Modelo_Productos getProducto() {
        return producto;
    }

    public void setProducto(Modelo_Productos producto) {
        this.producto = producto;
    }
    
}