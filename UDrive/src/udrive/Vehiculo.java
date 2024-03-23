
package udrive;

import java.io.Serializable;

/**
 *
 * @author Enner
 */
public class Vehiculo implements Serializable{
    
    private double gasolina,distancia,distanciado,trozo;
    private String  destino, inicio,T1;
    private int i, pos,l;
    private boolean br,si,ini,available;

    public Vehiculo(double gasolina, double distancia, double distanciado, String destino, String inicio, int i, int pos, boolean si, boolean br,String T1,boolean ini,int l,double trozo,boolean available) {
        this.gasolina = gasolina;
        this.distancia = distancia;
        this.distanciado = distanciado;
        this.destino = destino;
        this.inicio = inicio;
        this.i = i;
        this.pos = pos;
        this.si = si;
        this.br = br;
        this.T1=T1;
        this.ini=ini;
        this.l=l;
        this.trozo=trozo;
        this.available=available;
    }



    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public boolean isBr() {
        return br;
    }

    public void setBr(boolean br) {
        this.br = br;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @return the distanciado
     */
    public double getDistanciado() {
        return distanciado;
    }

    /**
     * @param distanciado the distanciado to set
     */
    public void setDistanciado(double distanciado) {
        this.distanciado = distanciado;
    }

    /**
     * @return the pos
     */
    public int getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * @return the si
     */
    public boolean isSi() {
        return si;
    }

    /**
     * @param si the si to set
     */
    public void setSi(boolean si) {
        this.si = si;
    }

    /**
     * @return the T1
     */
    public String getT1() {
        return T1;
    }

    /**
     * @param T1 the T1 to set
     */
    public void setT1(String T1) {
        this.T1 = T1;
    }

    /**
     * @return the ini
     */
    public boolean isIni() {
        return ini;
    }

    /**
     * @param ini the ini to set
     */
    public void setIni(boolean ini) {
        this.ini = ini;
    }

    /**
     * @return the l
     */
    public int getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(int l) {
        this.l = l;
    }

    /**
     * @return the trozo
     */
    public double getTrozo() {
        return trozo;
    }

    /**
     * @param trozo the trozo to set
     */
    public void setTrozo(double trozo) {
        this.trozo = trozo;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the si
     */
    
    
    
    
}
