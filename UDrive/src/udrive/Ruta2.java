
package udrive;

/**
 *
 * @author Enner
 */
public class Ruta2 extends Thread{
    Viajes viaje;
    private boolean b1=true;
    private double distancia;
    
    public Ruta2(Viajes viaje) {
        this.viaje = viaje;
        distancia=((Viajes.po2-120)/(Viajes.d2-Viajes.rec2));
    }
    @Override
    public void run(){
        try{
            while(b1){
                sleep(1000);
                if(Viajes.po2<=120){
                    pausar();
                    Viajes.disto2=Viajes.d2;
                    Viajes.btn22.setEnabled(true);
                }else{
                    Viajes.po2=(int)(Viajes.po2-distancia);
                    Viajes.rec2+=1;
                    Viajes.disto2+=1;
                    Viajes.gas2=Viajes.gas2-viaje.b;
                    Viajes.gast2+=Viajes.b;
                }
                if(Viajes.gas2<=0){
                        pausar();
                        this.viaje.btn23.setVisible(true);
                    }
                Viajes.LabelImagen2.setLocation((int) Viajes.po2, this.viaje.LabelImagen2.getY());
                Viajes.lbl26.setLocation((int) Viajes.po2, this.viaje.lbl26.getY());
                Viajes.btn23.setLocation((int) (Viajes.po2+135), this.viaje.btn23.getY());
                Viajes.lbl26.setText("Gasolina actual: "+ Math.round(Viajes.gas2) +"gal");
                Viajes.lbl25.setLocation((int) Viajes.po2, this.viaje.lbl25.getY());
                Viajes.lbl25.setText("Recorrido: "+ Viajes.disto2 +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void pausar(){
        b1=false;
    }
}
