
package udrive;

import javax.swing.JLabel;

/**
 *
 * @author Enner
 */
public class Ruta1 extends Thread{
    Viajes viaje;
    private boolean b1=true;
    public Ruta1(Viajes viaje) {
        this.viaje = viaje;
    }
    @Override
    public void run(){
        try{
            Generar.ll1=Generar.l1;
            Viajes.va1=false;
            while(b1){
                sleep(1000);
                if(Viajes.po1<=120){
                    pausar();
                    Viajes.disto1=Viajes.d1;
                    Viajes.br1=true;
                    Viajes.btn12.setEnabled(true);
                }else{
                    Viajes.po1=(int)(Viajes.po1-Viajes.trozo1);
                    Viajes.rec1+=1;
                    Viajes.disto1+=1;
                    Viajes.gas1=Viajes.gas1-viaje.a;
                    Viajes.gast1+=Viajes.a;
                }
                if(Viajes.gas1<=0 && Viajes.gas1!=-1){
                        pausar();
                        this.viaje.btn13.setVisible(true);
                        Viajes.reca1=true;
                    }
                Viajes.LabelImagen1.setLocation((int) Viajes.po1, this.viaje.LabelImagen1.getY());
                Viajes.lbl16.setLocation((int) Viajes.po1, this.viaje.lbl16.getY());
                Viajes.btn13.setLocation((int) (Viajes.po1+135), this.viaje.btn13.getY());
                Viajes.lbl16.setText("Gasolina actual: "+ Math.round(Viajes.gas1) +"gal");
                Viajes.lbl15.setLocation((int) Viajes.po1, this.viaje.lbl15.getY());
                Viajes.lbl15.setText("Recorrido: "+ Viajes.disto1 +"km");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
        public void pausar(){
        b1=false;
    }
}