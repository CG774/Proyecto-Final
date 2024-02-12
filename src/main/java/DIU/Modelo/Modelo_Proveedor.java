package DIU.Modelo;

public class Modelo_Proveedor {
    private int id_proveedor;
    private String nombre_proveedor;
    private String telefono_proveedor;
    private int id_producto;
    
    public Modelo_Proveedor() {
    }

    public Modelo_Proveedor(String nombre_proveedor, String telefono_proveedor, int id_producto) {
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.id_producto = id_producto;
    }
    
    

    public Modelo_Proveedor(int id_proveedor, String nombre_proveedor, String telefono_proveedor, int id_producto) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.id_producto = id_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "Modelo_Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", id_producto=" + id_producto + '}';
    }

    
}