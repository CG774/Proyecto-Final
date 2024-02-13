package DIU.Modelo;

import java.util.Date;

public class Modelo_Envios_General {
    private int id_envio_general;
    private int id_supermercado;
    private Date fecha;

    public Modelo_Envios_General() {
    }


    public Modelo_Envios_General(int id_supermercado, Date fecha) {
        this.id_supermercado = id_supermercado;
        this.fecha = fecha;
    }

    public int getId_envio_general() {
        return id_envio_general;
    }

    public void setId_envio_general(int id_envio_general) {
        this.id_envio_general = id_envio_general;
    }

    public int getId_supermercado() {
        return id_supermercado;
    }

    public void setId_supermercado(int id_supermercado) {
        this.id_supermercado = id_supermercado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
