
package udrive;

/**
 *
 * @author Enner
 */
public class Ruta11 extends Thread{
    Viajes viaje;
    private boolean b1=true;
    private double distancia,gas;
    private int pos;
    public Ruta11(Viajes viaje) {
        this.viaje = viaje;
        distancia=((Viajes.po1+710)/(Viajes.d1-Viajes.rec1));
        gas=viaje.g1;
    }
    @Override
    public void run(){
        try{
            while(b1){
                sleep(1000);
                if(Viajes.po1>=830){
                    pausar();
                    Viajes.btn12.setEnabled(true);
                }else{
                    Viajes.po1=(int)(distancia-Viajes.po1);
                    Viajes.rec1+=1;
                    gas=gas-viaje.a;
                }
                if(gas<=0){
                        pausar();
                        this.viaje.btn13.setVisible(true);
                    }
                Viajes.LabelImagen1.setLocation((int) Viajes.po1, this.viaje.LabelImagen1.getY());
                Viajes.lbl16.setLocation((int) Viajes.po1, this.viaje.lbl16.getY());
                Viajes.btn13.setLocation((int) (Viajes.po1+135), this.viaje.btn13.getY());
                Viajes.lbl16.setText("Gasolina actual: "+ Math.round(gas) +"gal");
                Viajes.lbl15.setLocation((int) Viajes.po1, this.viaje.lbl15.getY());
                Viajes.lbl15.setText("Recorrido: "+ Viajes.disto1+Viajes.rec1 +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void pausar(){
        b1=false;
    }
}
