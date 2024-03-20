package udrive;

import java.io.Serializable;

/**
 *
 * @author Enner
 */
public class Linea implements Serializable {

    private String fechaf, fechai, distancia, vehiculo, gasolina;
    public static int ID = 100;

    public Linea(String fechaf, String fechai, String distancia, String vehiculo, String gasolina) {
        this.fechaf = fechaf;
        this.fechai = fechai;
        this.distancia = distancia;
        this.vehiculo = vehiculo;
        this.gasolina = gasolina;
    }

    /**
     * @return the fechaf
     */
    public String getFechaf() {
        return fechaf;
    }

    /**
     * @param fechaf the fechaf to set
     */
    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }

    /**
     * @return the fechai
     */
    public String getFechai() {
        return fechai;
    }

    /**
     * @param fechai the fechai to set
     */
    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    /**
     * @return the distancia
     */
    public String getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the gasolina
     */
    public String getGasolina() {
        return gasolina;
    }

    /**
     * @param gasolina the gasolina to set
     */
    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

   

}
