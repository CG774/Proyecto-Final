package DIU.Modelo;

public class Modelo_Supermercado {
    private int id_supermercado;
    private String codSuper;
    private String nombre;
    private String telefono;
    private String encargado;

    public Modelo_Supermercado() {
    }

    public Modelo_Supermercado(int id_supermercado, String codSuper, String nombre, String telefono, String encargado) {
        this.id_supermercado = id_supermercado;
        this.codSuper = codSuper;
        this.nombre = nombre;
        this.telefono = telefono;
        this.encargado = encargado;
    }

    public int getId_supermercado() {
        return id_supermercado;
    }

    public void setId_supermercado(int id_supermercado) {
        this.id_supermercado = id_supermercado;
    }

    public String getCodSuper() {
        return codSuper;
    }

    public void setCodSuper(String codSuper) {
        this.codSuper = codSuper;
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

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "Modelo_Supermercado{" + "id_supermercado=" + id_supermercado + ", codSuper=" + codSuper + ", nombre=" + nombre + ", telefono=" + telefono + ", encargado=" + encargado + '}';
    }

   
}
