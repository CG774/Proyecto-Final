package DIU.Modelo;

/**
 * Clase que representa la entidad Gavetas.
 * 
 * La clase contiene los atributos correspondientes a la tabla gavetas.
 * 
 * @author carlo
 */
public class Modelo_Gavetas {
    private int id;
    private String color;
    private String tamanio;
    private double pesoMaximo;
    private String esPropia;
    private Modelo_Estados_GA idEstado;

    
    public Modelo_Gavetas() {
    }

    public Modelo_Gavetas(int id, String color, String tamanio, double pesoMaximo, String esPropia, Modelo_Estados_GA idEstado) {
        this.id = id;
        this.color = color;
        this.tamanio = tamanio;
        this.pesoMaximo = pesoMaximo;
        this.esPropia = esPropia;
        this.idEstado = idEstado;
    }

    public Modelo_Estados_GA getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Modelo_Estados_GA idEstado) {
        this.idEstado = idEstado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public String getEsPropia() {
        return esPropia;
    }

    public void setEsPropia(String esPropia) {
        this.esPropia = esPropia;
    }


}
